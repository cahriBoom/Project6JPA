package com.ocescalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voie {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_voie;
	
	@Column(name = "nom_voie")
	private String nom;
	
	@Column(name = "num_voie")
	private int numero;
	
	private String hauteur;
	
	private String cotation;
	
	// relation 1,p Bidirectionnelle avec voie
	@ManyToOne
	private Secteur secteur;
	
	
	// Constructors
	public Voie() {
		this("", 0, "", "");
	}


	public Voie(String string, int j, String k, String string2) {
		this.nom = string;
		this.numero = j;
		this.hauteur = k;
		this.cotation=string2;
	}
	
	


	//Getters and Setters
	public int getId_voie() {
		return id_voie;
	}

	public void setId_voie(int id_voie) {
		this.id_voie = id_voie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getHauteur() {
		return hauteur;
	}

	public void setHauteur(String hauteur) {
		this.hauteur = hauteur;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur sec) {
		this.secteur=sec;
	}
	
}
