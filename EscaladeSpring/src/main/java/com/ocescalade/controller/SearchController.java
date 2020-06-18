package com.ocescalade.controller;

import com.ocescalade.model.Search;
import com.ocescalade.model.Secteur;
import com.ocescalade.model.Site;
import com.ocescalade.model.Voie;
import com.ocescalade.service.SecteurService;
import com.ocescalade.service.SiteService;
import com.ocescalade.service.VoieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SearchController {

	@Autowired
	private SiteService siteService;
	
	@Autowired
	private VoieService voieService;
	
	@Autowired
	private SecteurService secteurService;
	
	@GetMapping("/search")
	public String getSearch(Model model) {
	    model.addAttribute("search", new Search());
	   
	    return "search";
	    }

	//méthode effectuant une recherche de mot clé dans la base de donnée
	@PostMapping("/search")
	public String postSearch(Model model, @ModelAttribute("search")Search search) {
		String searchString = search.getMot();
		List<Voie> resVoie = voieService.searchDB(searchString);
		List<Secteur> resSecteur = secteurService.searchDB(searchString);
		List<Site> resSite = siteService.findByResearch(searchString);
	
		model.addAttribute("voie", resVoie);
		model.addAttribute("secteur", resSecteur);
		model.addAttribute("site", resSite);
		
		return "search";
	}
	
}