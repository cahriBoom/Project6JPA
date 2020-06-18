package com.ocescalade.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Site;
import com.ocescalade.repository.SecteurRepository;
import com.ocescalade.service.SecteurService;

@Service
public class SecteurServiceImp implements SecteurService{

	@Autowired
	private SecteurRepository secteurRepository;
	
	@Override
	public List<Secteur> getAll() {
		return secteurRepository.findAll();
	}

	@Override
	public void addSecteur(Secteur s) {
		secteurRepository.save(s);
		
	}

	@Override
	public List<Secteur> getAllBySite(Site s) {
		return secteurRepository.findAllBySite(s);
	}

	@Override
	public List<Secteur> searchDB(String str) {
		return secteurRepository.findByNomContaining(str);
	}

	@Override
	public Optional<Secteur> getById(int id) {
		return secteurRepository.findById(id);
	}

}
