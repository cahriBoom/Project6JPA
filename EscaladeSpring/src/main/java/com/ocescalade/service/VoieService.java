package com.ocescalade.service;

import java.util.List;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Voie;

public interface VoieService {
	List<Voie> getAllVoie();
	List<Voie> getAllVoieById(int id);
	List<Voie> getAllVoieBySecteur(Secteur secteur);
	List<Voie> findByName(String name);
	
	List<Voie> searchDB(String str);
	
	void addVoie(Voie v);
}
