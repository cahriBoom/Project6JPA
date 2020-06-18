package com.ocescalade.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Site;
import com.ocescalade.service.SecteurService;
import com.ocescalade.service.SiteService;

@Controller
public class SecteurController {

	@Autowired
	private SecteurService secteurService;
	
	@Autowired
	private SiteService siteService;
	
	@GetMapping("/secteur/{id}")
	public String getSecteur(Map<String, Object> model, @PathVariable("id") int id) {
		List<Secteur> secteurs;
		Site site = siteService.findById(id).get();
		secteurs = secteurService.getAllBySite(site);
		
		// calcul le nombre total de voies par secteurs
		for(Secteur sec: secteurs) {
			int nb = sec.getVoies().size();
			sec.setNb(nb);
		}
		model.put("secteur", secteurs);
		return "/secteur";
	}
	
	@GetMapping("/addSecteur/{id}")
	public String getAddSecteur(Map<String, Object> model, @PathVariable("id") int id) {
		model.put("secteur", new Secteur());
		return "addSecteur";
	}
	
	
	@PostMapping("/addSecteur/{id}")
	public ModelAndView postAddSecteur(@ModelAttribute("secteur") Secteur sec, @PathVariable("id") int id, @Valid Secteur s, BindingResult result) {
		Site site = siteService.findById(id).get();
		sec.setId(1);
		sec.setSite(site);
		secteurService.addSecteur(sec);
		return new ModelAndView("redirect:/secteur/{id}");
	}
}
