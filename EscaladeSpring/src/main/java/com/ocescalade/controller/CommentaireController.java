package com.ocescalade.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ocescalade.model.Commentaire;
import com.ocescalade.model.Site;
import com.ocescalade.model.Utilisateur;
import com.ocescalade.service.CommentaireService;
import com.ocescalade.service.SiteService;
import com.ocescalade.service.UtilisateurService;

@Controller
public class CommentaireController {

	
	@Autowired
	public CommentaireService commentaireService;
	
	@Autowired
	public UtilisateurService utilisateurService;
	
	@Autowired
	public SiteService siteService;

	// Mapping de la vue /commentaire.
	// La méthode récupère tous les commentaire pour un site
	// id représente l'identifiant du site.
	@GetMapping("/commentaire/{id}")
	public String getCommentaire(Map<String, Object> model, @PathVariable("id") int id) {
    	List<Commentaire> coms;
    	Optional<Site> s = siteService.findById(id);
    	coms = commentaireService.showAllCommentaireBySite(s.get());
    	model.put("commentaire", coms);
    	return "commentaire";
    }
	
	// Méthode permettant de supprimer un commentaire
	@GetMapping("/supprComment/{id}")
	public ModelAndView getDeleteCommentaire(Map<String, Object> model, @PathVariable("id") int id){
		Commentaire c = commentaireService.findById(id).get();
		Site site = c.getSite();
		commentaireService.deleteCommentaire(id);
		return new ModelAndView("redirect:/commentaire/" + site.getId());
	}

	@GetMapping("/addComments/{id}")
	public String getAddCommentaire(Map<String, Object> model, @PathVariable("id") int id){
		model.put("commentaire", new Commentaire());
		return "addComments";
	}
	
	// méthode permettant d'ajouter un commentaire sur le site.
	// Avant d'ajouter le commentaire. On récupère toutes les informations nécessaires pour la création
	@PostMapping("/addComments/{id}")
	public ModelAndView postAddCommentaire(@ModelAttribute("commentaire") Commentaire comments, @PathVariable("id") int id,BindingResult result, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Utilisateur util = utilisateurService.findByEmail(name).get();
		Site s = siteService.findById(id).get();
		
		String contenu = comments.getContenu();
		Commentaire comm = new Commentaire(Calendar.getInstance().getTime(), contenu, util, s);
		commentaireService.addCommentaire(comm);
		return new ModelAndView("redirect:/commentaire/{id}")  ;
	}
	
	@GetMapping("/modifyComment/{id}")
	public String getModifyCommentaire(Map<String, Object> model, @PathVariable("id") int id){
		Commentaire commentaire = commentaireService.findById(id).get();
		Site site = commentaire.getSite();
		int id_site = site.getId();
		model.put("commentaire", commentaire);
		model.put("id_site", id_site);
		return "/modifyComment";
	}
	
	// méthode permettant de modifier le contenu du commentaire, sans changer l'utilisateur
	@PostMapping("/modifyComment/{id}")
	public ModelAndView postModifyCommentaire(@ModelAttribute("commentaire") Commentaire comment, @PathVariable("id") int id,BindingResult result) {
		Commentaire c = commentaireService.findById(comment.getId()).get();
		c.setContenu(comment.getContenu());
		commentaireService.updateCommentaire(c);
		Site s= c.getSite();
		
		return new ModelAndView("redirect:/commentaire/" + s.getId());
	}
}
