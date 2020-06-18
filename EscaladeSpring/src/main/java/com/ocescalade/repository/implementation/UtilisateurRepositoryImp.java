package com.ocescalade.repository.implementation;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ocescalade.model.Topo;
import com.ocescalade.model.Utilisateur;
import com.ocescalade.repository.UtilisateurRepository;

@Repository("UtilisateurRepository")
@Service
public class UtilisateurRepositoryImp implements UtilisateurRepository {

   
 
	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Utilisateur> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Utilisateur> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends Utilisateur> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteInBatch(Iterable<Utilisateur> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Utilisateur getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Utilisateur> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Utilisateur> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Page<Utilisateur> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Utilisateur> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<Utilisateur> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Utilisateur entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll(Iterable<? extends Utilisateur> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends Utilisateur> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Utilisateur> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Utilisateur> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public <S extends Utilisateur> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Optional<Utilisateur> findByMail(String mail_utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Optional<Utilisateur> findByNomAndPassword(String nom, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Utilisateur> findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topo> findToposOwnedByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
	




}
