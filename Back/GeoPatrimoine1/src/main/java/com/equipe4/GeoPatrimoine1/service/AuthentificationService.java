package com.equipe4.GeoPatrimoine1.service;

import com.equipe4.GeoPatrimoine1.entity.Authentification;
import com.equipe4.GeoPatrimoine1.repository.AuthentificationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    @Autowired
    private AuthentificationRepository authentificationRepository;

    public List<Authentification> findAll(){
        return authentificationRepository.findAll();
    }
    
    public Authentification findById(Long id){
        return authentificationRepository.findOneById(id);
    }
    
    public Authentification findByLoginAndMdp (String login, String mdp){
        return authentificationRepository.findByUtilisateurAndMotDePasse(login, mdp);
    }
    
    
}
