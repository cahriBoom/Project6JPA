package com.ocescalade.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocescalade.model.Commentaire;
import com.ocescalade.model.Site;
import com.ocescalade.repository.CommentaireRepository;
import com.ocescalade.service.CommentaireService;


@Service
public class CommentaireServiceImp implements CommentaireService{

	@Autowired
	private CommentaireRepository commentaireRepository;
	
	
	@Override
	public List<Commentaire> showAllCommentaireBySite(Site site) {
		return commentaireRepository.findAllBySite(site);
	}

	@Override
	public void addCommentaire(Commentaire c) {
		commentaireRepository.save(c);
	}

	@Override
	public Optional<Commentaire> findById(int id) {
		return commentaireRepository.findById(id);
	}

	@Override
	public void deleteCommentaire(int id) {
		List<Commentaire> commentaires = commentaireRepository.findAll();
		for(Commentaire c:commentaires) {
			// Supprime le commentaire dans la liste de tous les commentaires
			if(c.getId()==id) {
				commentaireRepository.delete(c);
			}
		}
	}
	
	@Override
	public List<Commentaire> getAllCommentaire() {
		return commentaireRepository.findAll();
	}

	@Override
	public void updateCommentaire(Commentaire c) {
		commentaireRepository.save(c);
	}
	
}
