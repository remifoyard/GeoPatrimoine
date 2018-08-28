package com.equipe4.GeoPatrimoine1.service;

import com.equipe4.GeoPatrimoine1.entity.Utilisateur;
import com.equipe4.GeoPatrimoine1.repository.UtilisateurRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }
    
    public Utilisateur findById(Long id){
        return utilisateurRepository.findOneById(id);
    }
    
    public Utilisateur findByLoginAndMdp (String login, String mdp){
        return utilisateurRepository.findByLoginAndMotDePasse(login, mdp);
    }
    
    public Utilisateur findByLogin (String login){
        return utilisateurRepository.findByLogin(login);
    }
    
    
}
