package com.ocescalade.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ocescalade.service.UtilisateurService;


@Controller
public class MainController{

	@Autowired
	public UtilisateurService utilisateurService;
	
	@GetMapping("/accueil")
	public String getAccueil(ModelMap model) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		System.out.println(name);
	    model.addAttribute("current", name);

    	return "accueil";
	}
	
	@GetMapping("/welcome/{name}")
	public String getProfil(Map<String, Object> model, @PathVariable("name") String name) {   	
		String username = utilisateurService.findByEmail(name).get().getPrenom();
		model.put("prenom", username);
		return "welcome";
    }
			
	@GetMapping(value="/logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/connexion";
	}
}
