package com.ocescalade.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;
import com.ocescalade.repository.TopoRepository;
import com.ocescalade.service.TopoService;

@Service
public class TopoServiceImp implements TopoService {

	
	@Autowired
	private TopoRepository topoRepository;

	
	@Override
	public List<Topo> getAllTopos(){
		return topoRepository.findAll();
	}
	
	
	@Override
	public List<Topo> getAllToposByUsername(Utilisateur u){
		return topoRepository.findAllByCreateur(u);
	}
	
	@Override
	public void addTopo(Topo t) {
		topoRepository.save(t);
		
	}


	@Override
	public Optional<Topo> getTopoById(int id) {
		return topoRepository.findById(id);
	}


	@Override
	public void updateTopo(Topo t) {
		topoRepository.save(t);
	}


}
