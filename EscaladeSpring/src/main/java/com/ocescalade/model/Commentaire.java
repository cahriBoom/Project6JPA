package com.ocescalade.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


@Entity
public class Commentaire {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column( name="id_commentaire" )
	private int id;
	
	@Column( name="date_commentaire" )
	private Date date;
	
	@Column( name="contenu_commentaire" )
	private String contenu;
	
	//relation 1,p Utilisateur unidirectionnelle
	@ManyToOne(cascade=CascadeType.ALL)
	private Utilisateur user;

	//relation 1,p Site bidirectionnelle
	@ManyToOne(cascade=CascadeType.ALL)
	private Site site;
			
	//Constructors
	public Commentaire() {
		this(Calendar.getInstance().getTime(),"", new Utilisateur(), new Site());
	}
	
	
	public Commentaire(Date date, String comm, Utilisateur u, Site s) {
		this.date = date;
		this.contenu = comm;
		this.user = u;
		this.site = s;
	}

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String commentaire) {
		this.contenu = commentaire;
	}


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}

	
	
}
