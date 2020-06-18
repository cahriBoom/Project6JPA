package com.ocescalade.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Secteur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column( name="id_secteur" )
	private int id;
	
	@Column(name = "nom_secteur")
	private String nom;
	
	@Column(name="nb_voie")
	private int nb;
	
	@OneToMany(mappedBy="secteur")
	private List<Voie> voies;
	
	@ManyToOne
	private Site site;
	
	//Constructors
	public Secteur() {
		this("", 0);
	}
	
	public Secteur(String nom, int nb) {
		this.nom=nom;
		this.nb=nb;
	}


	// Getters and Setters 
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}


