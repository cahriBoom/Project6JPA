package com.ocescalade.service;

import java.util.List;
import java.util.Optional;

import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UtilisateurService extends UserDetailsService {

	List<Utilisateur> getAllUsers() throws Exception;
	List<Topo> getToposByMail(String username);
	Optional<Utilisateur> findById(int id);
	Optional<Utilisateur> findByEmail (String name);
	void addUser(Utilisateur u);
	boolean isUserTaken (Utilisateur u); 
	
}
