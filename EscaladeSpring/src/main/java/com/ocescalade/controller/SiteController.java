package com.ocescalade.controller;

import java.util.ArrayList;
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

import com.ocescalade.model.Commentaire;
import com.ocescalade.model.Site;
import com.ocescalade.service.SiteService;

@Controller
public class SiteController {

	@Autowired
	private SiteService siteService;
	
	@GetMapping("/liste")
	public String getSite(Map<String, Object> model) {
    	List<Commentaire> commentaires = new ArrayList<>();
    	List<Site> sites;
    	sites=siteService.getAllSite();
    	// calcul le nombre total de secteurs et de commentaires par sites
    	for(Site s: sites) {
    		int nb = s.getSecteurs().size();
    		commentaires = s.getCommentaires();
    		s.setNb_commentaire(commentaires.size());
    		s.setNb(nb);
    	}
    	
    	model.put("site", sites);
    	return "liste";
    }
	
    @GetMapping("/addSite")
    public String getAddSite(Map<String, Object> model) {
    	model.put("site", new Site());
    	return "addSite";
    }
    
    
    @PostMapping("/addSite")
    public ModelAndView postAddSite(@ModelAttribute("site") Site site, @Valid Site s, BindingResult result){
    	siteService.addSite(site);
    	return new ModelAndView("redirect:/liste");
    }
	
    // méthode permettant de changer le status du Site en Officiel ou non Officiel
    @GetMapping("/validationOfficial/{id}")
	public ModelAndView getValidationOfficial(Map<String, Object> model, @PathVariable("id") int id) {
    	Site site = siteService.findById(id).get();
    	int favoris = site.getFavoris();
    	if(favoris==1) {
    		site.setFavoris(0);
    	}
    	if(favoris==0) {
    		site.setFavoris(1);
    	}
    	siteService.addSite(site);
    	return new ModelAndView("redirect:/liste");
    }
      
}
