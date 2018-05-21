package com.equipe4.GeoPatrimoine1.entity;

import javax.persistence.*;

@Entity
public class Authentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "utilisateur")
    private String utilisateur;

    @Column(name = "motDePasse")
    private String motDePasse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
    
    
}
