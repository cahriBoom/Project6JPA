package com.ocescalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer>{

	List<Topo> findAllByCreateur(Utilisateur u);
	
}
