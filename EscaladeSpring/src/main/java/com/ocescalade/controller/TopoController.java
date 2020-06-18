package com.ocescalade.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ocescalade.model.Site;
import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;
import com.ocescalade.service.SiteService;
import com.ocescalade.service.TopoService;
import com.ocescalade.service.UtilisateurService;


@Controller
public class TopoController {

	@Autowired
    private TopoService topoService;
		
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	// Affiche la liste complète des topos disponible
    @GetMapping("/topo")
	public String getTopo(Map<String, Object> model) throws Exception {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String mail = auth.getName();
    	Utilisateur user = utilisateurService.findByEmail(mail).get();
    	List<Topo> topos = topoService.getAllTopos();;
    	List<Topo> newTopos = new ArrayList<>();
    	for(Topo t : topos) {
    		// vérification si le topo est disponible
    		if(t.getTopo_disp()==1) {
    			if(t.getCreateur()!=user) {
    				newTopos.add(t);
    			}
    		}
    	}
    	model.put("topos", newTopos);
    	return "topo";
    }
      
    
    @GetMapping("/addTopo")
    public String getAddTopo(Map<String, Object> model) {
    	List<Site> sites = siteService.getAllSite();
    	model.put("sites", sites);
    	model.put("site", new Site());
    	return "/addTopo";
    }
    
    // Ajoute le Topo à la liste. Et le rends "Disponible" par défaut
    @PostMapping("/addTopo")
    public ModelAndView postAddTopo(@ModelAttribute("Site") Site s, @Valid Site v, BindingResult result ) {  
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String mail = auth.getName();
    	Utilisateur user = utilisateurService.findByEmail(mail).get();
    	
    	Topo t = new Topo(1, "Disponible", user, LocalDate.now());
    	Site site = siteService.findByName(s.getNom());
    	t.setSite(site);
    	
    	topoService.addTopo(t);
    	return new ModelAndView("redirect:/topo");
    }
      
    // Effectue la demande de réservation à l'utilisateur. Et place le Topo "En Attente"
    // Et retire le topo de la liste des topo disponible.
    @GetMapping("/reservTopo/{id}")
    public ModelAndView getReservTopo(Map<String, Object> model, @PathVariable("id") int id) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String mail = auth.getName();
    	Utilisateur user = utilisateurService.findByEmail(mail).get();
    	Topo topo = topoService.getTopoById(id).get();
    	
    	user.setTopo(topo);
    	topo.setLoueur(user);
    	topo.setEtat("En Attente");
    	topo.setTopo_disp(2);
    	
    	topoService.updateTopo(topo);
    	return new ModelAndView("redirect:/topo");
    }
       
    // Accepte la demande de réservation. Et rends le topo "Réservé".
    @GetMapping("/reservValidation/{id}")
    public ModelAndView getReservValidation(Map<String, Object> model, @PathVariable("id") int id) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String mail = auth.getName();
    	Utilisateur user = utilisateurService.findByEmail(mail).get();
    	Topo topo = topoService.getTopoById(id).get();
    	
    	user.setTopo(topo);
    	topo.setLoueur(user);
    	topo.setEtat("Réservé");
    	topo.setTopo_disp(0);
    	
    	topoService.updateTopo(topo);
    	return new ModelAndView("redirect:/consultReservation/" + mail);
    }
    
    // Rejette la demande de réservation et rends le Topo "Disponible"
    @GetMapping("/reservReject/{id}")
    public ModelAndView getReservReject(Map<String, Object> model, @PathVariable("id") int id) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String mail = auth.getName();
    	Topo topo = topoService.getTopoById(id).get();
    	topo.setEtat("Disponible");
    	topo.setTopo_disp(1);
    	
    	topoService.updateTopo(topo);
    	return new ModelAndView("redirect:/consultReservation/" + mail);
    }
    
    // Permet de consulter la liste des topo que l'utilisateur connecté a enregistré
    @GetMapping("/consultTopos/{username}")
    public String getConsultTopo(Map<String, Object> model, @PathVariable("username") String username) {
    	Utilisateur u = utilisateurService.findByEmail(username).get();
    	List<Topo> topoOwned = topoService.getAllToposByUsername(u);
    	u.setToposOwned(topoOwned);   	
    	model.put("owned", u.getToposOwned());
    	return "/consultTopos";
    }
    
    // Affiche la liste complète des demandes réservation en cours
    @GetMapping("/consultReservation/{username}")
    public String getConsultReservation(Map<String, Object> model, @PathVariable("username") String username) {
    	Utilisateur u = utilisateurService.findByEmail(username).get();
    	List<Topo> topos = topoService.getAllToposByUsername(u);
    	List<Topo> toposResa = new ArrayList<>();
    	
    	for(Topo t:topos) {
    		if(t.getTopo_disp()==2) {
 			toposResa.add(t);
    		}
    	}
    	
    	model.put("topos", toposResa);
    	return "/consultReservation";
    }

    // Change le status du topo selectionner.
    // Si topo est "Disponible", le Topo change à "Indisponible"
    // Si topo est "En Attente", le topo change à "Réservé"
    // Si topo est "Réservé", le topo change à "Disponible"
    @GetMapping("/changeStatusTopo/{id}")
    public ModelAndView getChangeStatusTopo(Map<String, Object> model, @PathVariable("id") int id) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String mail = auth.getName();
    	Topo topo = topoService.getTopoById(id).get();
    	int etat = topo.getTopo_disp();
    	
    	if(etat ==  1 ) {
    		topo.setTopo_disp(0);
    		topo.setEtat("Indisponible");
    		topo.setLoueur(null);
    	}
    	if(etat == 2) {
    		topo.setTopo_disp(0);
    		topo.setEtat("Réservé");
    	}
    	if(etat == 0) {
    		topo.setTopo_disp(1);
    		topo.setEtat("Disponible");
    		topo.setLoueur(null);
    	}
    	
    	topoService.updateTopo(topo);
    	return new ModelAndView("redirect:/consultTopos/" + mail);
    }
    	

    
}
