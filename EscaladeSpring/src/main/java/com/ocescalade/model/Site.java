package com.ocescalade.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column( name="id_site" )
	private int id;
	
	@Column( name="lieu_site")
	private String nom;
	
	@Column ( name ="site_ville")
	private String ville;
	
	private int favoris;
	
	@Column( name="nb_secteur")
	private int nb;
	
	private int nb_commentaire;
		
	//Relation 1,p secteurs Unidirectionnel
	@OneToMany(mappedBy="site")
	private Collection <Secteur> secteurs;

	//Relation 1,p bidirectionnelle
	@OneToMany(mappedBy="site")
	private List <Commentaire> commentaires;
	
	//Relation n,p bidirectionnel
	@OneToMany(mappedBy="site")
	private List<Topo> topos = new ArrayList<>();
	
	//Constructors
	public Site() {
		this("", "", 0, 0);
	}
	
	public Site(String name, String ville, int f, int j) {
		this.nom=name;
		this.ville = ville;
		this.favoris = f;
		this.nb=j;
	}
	
	
	//Getters and Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Collection<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Collection<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Topo> getTopos() {
		return topos;
	}

	public void setTopos(List<Topo> topos) {
		this.topos = topos;
	}

	public int getNb_commentaire() {
		return nb_commentaire;
	}

	public void setNb_commentaire(int nb_commentaire) {
		this.nb_commentaire = nb_commentaire;
	}

	public int getFavoris() {
		return favoris;
	}

	public void setFavoris(int favoris) {
		this.favoris = favoris;
	}
	
	
}
