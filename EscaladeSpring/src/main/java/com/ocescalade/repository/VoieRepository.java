package com.ocescalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Voie;

@Repository
public interface VoieRepository extends JpaRepository<Voie, Integer> {

	List<Voie> findByNom(String name);
	List<Voie> findBySecteur(Secteur secteur);
	List<Voie> findByCotationContaining(String str);
	List<Voie> findByNomContaining(String str);
	List<Voie> findByHauteur(int i);
}
