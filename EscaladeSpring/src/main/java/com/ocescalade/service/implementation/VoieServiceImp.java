package com.ocescalade.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Voie;
import com.ocescalade.repository.VoieRepository;
import com.ocescalade.service.VoieService;

@Service
public class VoieServiceImp implements VoieService{

	@Autowired
	private VoieRepository voieRepository;
	
	@Override
	public List<Voie> getAllVoie(){
		return voieRepository.findAll();
	}

	@Override
	public List<Voie> getAllVoieById(int id){
		List<Voie> voiesAll = voieRepository.findAll();
		List<Voie> voiesAll2 = new ArrayList<>();
		for( Voie v : voiesAll) {
			Secteur sec = v.getSecteur();
			// Trie les voies, Affiche les voies ayant l'ID du site
			if(sec.getId()==id) {
				voiesAll2.add(v);
			}
		 }
		 return voiesAll2;
	}

	@Override
	public List<Voie> getAllVoieBySecteur(Secteur secteur){
		return voieRepository.findBySecteur(secteur);
	}
	
	
	@Override
	public List<Voie> findByName(String name) {
		return voieRepository.findByNom(name);
	}
	
	@Override
	public List<Voie> searchDB(String str){
		List<Voie> resultat;
		try
        { 
			int i = Integer.parseInt(str);
			resultat = voieRepository.findByHauteur(i);
    		return resultat;
			
        }  
        catch (NumberFormatException e) 
        { 
        	resultat = voieRepository.findByNomContaining(str);
    		if(!resultat.isEmpty()) {
    			return resultat;
    		}
    		
    		resultat = voieRepository.findByCotationContaining(str);
			return resultat;
    		
        } 
		
	}
	
	@Override
	public void addVoie(Voie v) {
		voieRepository.save(v);
	}
	
}
