package com.ocescalade.service;

import java.util.List;
import java.util.Optional;

import com.ocescalade.model.Commentaire;
import com.ocescalade.model.Site;

public interface CommentaireService {

	List<Commentaire> getAllCommentaire();
	List<Commentaire> showAllCommentaireBySite(Site site);
	Optional<Commentaire> findById(int id);
	void addCommentaire(Commentaire c);
	void updateCommentaire(Commentaire c);
	void deleteCommentaire(int id);
	
}
