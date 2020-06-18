package com.ocescalade.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {
	
	List<Topo> findToposOwnedByMail(String mail);
	
	Optional<Utilisateur> findByMail(String mail_utilisateur);
	Optional<Utilisateur> findByNomAndPassword(String nom, String pass);
	Optional<Utilisateur> findByNom(String nom);
}

