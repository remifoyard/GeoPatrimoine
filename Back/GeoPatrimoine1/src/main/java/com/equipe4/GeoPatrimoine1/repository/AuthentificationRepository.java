package com.equipe4.GeoPatrimoine1.repository;

import com.equipe4.GeoPatrimoine1.entity.Authentification;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthentificationRepository extends JpaRepository<Authentification, Long> {
	
	Authentification findOneById(Long id);
	
	Authentification findByUtilisateurAndMotDePasse(String utilisateur, String mdp);
}
