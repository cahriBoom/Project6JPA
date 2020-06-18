package com.ocescalade.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Topo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_topo;
	
	@Column( name="topo_disponible" )
	private int topo_disp;
		
	private String etat;
	
	private LocalDate parution;
	
	@ManyToOne
	private Utilisateur createur;
	
	//Relation 1,1 unidirectionnel
	@OneToOne
	private Utilisateur loueur;
	
	//Relation n,p bidirectionnel
	@ManyToOne
	private Site site;
	
	// Constructors
	public Topo() {
		this(0, "Disponible", new Utilisateur(), LocalDate.now());
	}


	public Topo(int b, String e,Utilisateur user, LocalDate date) {
		this.topo_disp=b;
		this.etat = e;
		this.createur = user;
		this.parution = date;
	}


	// Getters and Setters
	public int getId_topo() {
		return id_topo;
	}


	public void setId_topo(int id_topo) {
		this.id_topo = id_topo;
	}


	public int getTopo_disp() {
		return topo_disp;
	}


	public void setTopo_disp(int topo_disp) {
		this.topo_disp = topo_disp;
	}


	public Utilisateur getCreateur() {
		return createur;
	}


	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}



	public Utilisateur getLoueur() {
		return loueur;
	}


	public void setLoueur(Utilisateur loueur) {
		this.loueur = loueur;
	}


	public LocalDate getParution() {
		return parution;
	}


	public void setParution(LocalDate parution) {
		this.parution = parution;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	

}
