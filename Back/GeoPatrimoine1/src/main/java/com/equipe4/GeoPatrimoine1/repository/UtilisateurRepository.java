package com.equipe4.GeoPatrimoine1.repository;

import com.equipe4.GeoPatrimoine1.entity.Utilisateur;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Utilisateur findOneById(Long id);
	
	Utilisateur findByLoginAndMotDePasse(String login, String mdp);
	
	Utilisateur findByLogin(String login);
}
