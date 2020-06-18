package com.ocescalade.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocescalade.model.Site;
import com.ocescalade.repository.SiteRepository;
import com.ocescalade.service.SiteService;

@Service
public class SiteServiceImp implements SiteService{

	
	@Autowired
	private SiteRepository siteRepository;
	
	@Override
	public List<Site> getAllSite() {
		return siteRepository.findAll();
	}

	@Override
	public Optional<Site> findById(int id) {
		return siteRepository.findById(id);
	}

	@Override
	public Site findByName(String name) {
		return siteRepository.findByNom(name);
	}


	@Override
	public List<Site> findByResearch(String str) {
		List<Site> site = siteRepository.findByNomContaining(str);
		if(site.isEmpty()) {
			site = siteRepository.findByVilleContaining(str);
		}
		return site;
	}

	@Override
	public void addSite(Site s) {
		siteRepository.save(s);
	}
	
}
