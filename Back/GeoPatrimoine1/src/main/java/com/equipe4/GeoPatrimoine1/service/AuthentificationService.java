package com.equipe4.GeoPatrimoine1.service;

import com.equipe4.GeoPatrimoine1.entity.Authentification;
import com.equipe4.GeoPatrimoine1.repository.AuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    @Autowired
    private AuthentificationRepository authentificationRepository;

    public Authentification findById(Long id){
        return authentificationRepository.getOne(id);
    }
}
