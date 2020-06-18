package com.ocescalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocescalade.model.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

	Site findByNom(String name);
	
	List<Site> findByNomContaining(String str);
	List<Site> findByVilleContaining (String str);
	
}
