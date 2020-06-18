package com.ocescalade.service;

import java.util.List;
import java.util.Optional;

import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;

public interface TopoService {

	List<Topo> getAllTopos();
	List<Topo> getAllToposByUsername(Utilisateur u);
	Optional<Topo> getTopoById(int id);
	
	void addTopo(Topo t);
	void updateTopo (Topo t);
	
}
