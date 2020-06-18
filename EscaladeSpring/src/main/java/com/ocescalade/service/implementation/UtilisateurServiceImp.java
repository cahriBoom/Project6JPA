package com.ocescalade.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ocescalade.model.*;
import com.ocescalade.repository.UtilisateurRepository;
import com.ocescalade.service.UtilisateurService;

@Service("userService")
public class UtilisateurServiceImp implements UtilisateurService {

	
	@Autowired
	private UtilisateurRepository utilisateurRepository;


	@Override
	public List<Utilisateur> getAllUsers() throws Exception {
		return utilisateurRepository.findAll();
	}

	@Override
	public Optional<Utilisateur> findById(int id) {
		return utilisateurRepository.findById(id);
	}
	
	public Optional<Utilisateur> findByEmail(String nom) {
		return utilisateurRepository.findByMail(nom);
	}
		
	@Override
	public void addUser(Utilisateur u){
		utilisateurRepository.save(u);
	}

	@Override
	public boolean isUserTaken (Utilisateur u) {
		return (u.getMail() == null) ? false : true;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Utilisateur user = utilisateurRepository.findByMail(s)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
		
	}

	@Override
	public List<Topo> getToposByMail(String mail) {
		return utilisateurRepository.findToposOwnedByMail(mail);
	}

}
