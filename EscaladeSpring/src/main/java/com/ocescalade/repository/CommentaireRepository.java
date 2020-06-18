package com.ocescalade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocescalade.model.Commentaire;
import com.ocescalade.model.Site;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer>{

	List<Commentaire> findAllBySite(Site site);
}
