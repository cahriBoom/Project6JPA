package com.ocescalade.service;

import java.util.List;
import java.util.Optional;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Site;

public interface SecteurService {

	List<Secteur> getAll();
	List<Secteur> getAllBySite(Site s);
	Optional<Secteur> getById(int id);
	List<Secteur> searchDB(String str);
	void addSecteur(Secteur s);
}
