package com.ocescalade.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Voie;
import com.ocescalade.service.SecteurService;
import com.ocescalade.service.VoieService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VoieController {

    	
	@Autowired
	private SecteurService secteurService;
	
	@Autowired
	private VoieService voieService;

    
    @GetMapping("/description/{id}")
    public String getVoie(Map<String, Object> model, @PathVariable("id") int id) {
    	List<Voie> voies = voieService.getAllVoieById(id);
    	model.put("voie", voies);
    	return "description";
    }
      

    @GetMapping("/addVoie/{id}")
    public String getAddVoie(Map<String, Object> model, @PathVariable("id") int id) {
    	model.put("voie", new Voie());
    	return "addVoie";
    }

    @PostMapping("/addVoie/{id}")
    public ModelAndView postAddVoie(Map<String, Object> model, @ModelAttribute("voie") Voie v, @PathVariable("id") int id, @Valid Voie s, BindingResult result){
    		Secteur sec = secteurService.getById(id).get();
        	int num = voieService.getAllVoieBySecteur(sec).size()+1;
        	v.setSecteur(sec);
        	v.setNumero(num);
        	String hauteur = v.getHauteur();
        	
        	// Test si la hauteur saisie par l'utilisateur est correct.
        	if(isNumeric(hauteur)) {
        		System.out.println("INT");
        		voieService.addVoie(v);
        	}else if(isFloat(hauteur)) {
        		System.out.println("FLOAT");
        		voieService.addVoie(v);
        	}else {
        		String error = "Hauteur éronnée";
        		model.put("error", error);
        		return new ModelAndView("redirect:/addVoie/{id}");
        	}
        	        	
        		
        	return new ModelAndView("redirect:/description/{id}");
	}
    
    // Handlers for NumberFormatException
 	public boolean isNumeric(String str) {
     	try {
     		Integer.parseInt(str);
     		return true;
     	}catch(NumberFormatException e) {
     		return false;
     	}
     }
     
     public boolean isFloat(String str) {
     	try {
     		Float.parseFloat(str); 
     		return true;
     	}catch(NumberFormatException e) {
     		return false;
     	}
     }
    
}
