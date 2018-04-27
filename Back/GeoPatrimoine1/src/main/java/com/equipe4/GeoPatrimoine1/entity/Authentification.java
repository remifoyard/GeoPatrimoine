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
}
