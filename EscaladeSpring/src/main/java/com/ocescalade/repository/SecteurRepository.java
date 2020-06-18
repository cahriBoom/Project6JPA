package com.ocescalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocescalade.model.Secteur;
import com.ocescalade.model.Site;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer>{

	List<Secteur> findAllBySite(Site s);
	List<Secteur> findByNomContaining(String str);
}
