package com.ocescalade.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ocescalade.model.Utilisateur;
import com.ocescalade.service.UtilisateurService;


@Controller
public class UtilisateurController {

	@Autowired
	public UtilisateurService utilisateurService;
 
	
	@GetMapping(value = "/connexion")
	public ModelAndView loginGet(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("/connexion");
	}

	
	@PostMapping(value = "/connexion")
	public ModelAndView loginPost(Model model, @ModelAttribute("utilisateur") Utilisateur utilisateur) {
		return new ModelAndView("redirect:/accueil");
	}

	@GetMapping("/inscription")
	public String inscription(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "/inscription";
	}


	@PostMapping("/inscription")
	public String creationUtilisateur(Model model ,@ModelAttribute("utilisateur") Utilisateur utilisateur, @Valid Utilisateur s, BindingResult result) {
		// test si utilisateur existe deja
		Optional<Utilisateur> u = utilisateurService.findByEmail(utilisateur.getMail());
		if(u.isEmpty()){
			utilisateurService.addUser(utilisateur);
			return "/inscriptionValidee";
		}else{
			String message = "Utilisateur indisponible";
			model.addAttribute("msg", message);
			return "/inscription";
		}
	}

}

