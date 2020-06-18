package com.ocescalade.service;

import java.util.List;
import java.util.Optional;

import com.ocescalade.model.Site;

public interface SiteService {

	List<Site> getAllSite();
	
	Site findByName(String name);
	Optional<Site> findById(int id);
	List<Site> findByResearch(String str);
	
	void addSite(Site s);

}
