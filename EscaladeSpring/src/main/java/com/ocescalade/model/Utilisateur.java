package com.ocescalade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ocescalade.config.BCryptManagerUtil;

@Entity
public class Utilisateur implements Serializable, UserDetails{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column( name="num_utilisateur" )
	private int id_utilisateur;
	
	@Column( name="nom_utilisateur" )
	private String nom;
	
	@Column( name="prenom_utilisateur" )
	private String prenom;
	
	@Column( name="mail_utilisateur" )
	private String mail;
	
	@Column( name="password_utilisateur" )
	private String password;
	
	@Column( name="Admin" )
	private boolean admin = false;

	//Relation 1,p bidirectionnelle
	@OneToMany(mappedBy="createur")
	private List<Topo> toposOwned;
	
	@ManyToOne
	private Topo topo;
		
	
	// Constructors
	public Utilisateur() {
		this("","", "", "", false);
	}
	
	public Utilisateur(String nom, String prenom, String mail, String password, boolean admin) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = BCryptManagerUtil.passwordencoder().encode(password);
		this.admin = admin;
	}
	

	// Getters And Setters
	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password){
		if (!password.isEmpty()) {
			this.password = BCryptManagerUtil.passwordencoder().encode(password);
		}
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

		
	public List<Topo> getToposOwned() {
		return toposOwned;
	}

	public void setToposOwned(List<Topo> topos) {
		this.toposOwned = topos;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	
	// Methods
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsername() {
		String mail = this.getMail();
		return mail;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
