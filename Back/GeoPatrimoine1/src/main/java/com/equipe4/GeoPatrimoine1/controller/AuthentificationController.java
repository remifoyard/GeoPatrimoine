package com.equipe4.GeoPatrimoine1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equipe4.GeoPatrimoine1.entity.Authentification;
import com.equipe4.GeoPatrimoine1.service.AuthentificationService;


/**
 * Ressource REST pour l'entit� Authentification.
 */
@RestController
@RequestMapping(value = "/api")
public class AuthentificationController {
	
	@Autowired
	private AuthentificationService authentificationService;
	
	/**
	 * GET /patrimoineHistorique -> récupérer tous les administrateurs .
	 *
	 * @return la liste des administrateur
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Authentification> findAllUsers() {
		return authentificationService.findAll();
	}
	
	/**
	 * GET /admin/:id -> récupérer l'administrateur par son id.
	 *
	 * @param id de l'administrateur
	 * @return l'administrateur
	 */
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Authentification findById(@PathVariable final Long id) {
		//LOGGER.debug("Requête REST pour récupérer l'administrateur  à partir de son id.");
		return authentificationService.findById(id);
	}
	
	/**
	 * GET /admin/:login, mdp -> récupérer l'administrateur par la combinaison de son login et mdm.
	 *
	 * @param login de l'administrateur, mdp de l'administrateur
	 * @return l'administrateur
	 */
	@RequestMapping(value = "/admin/login/mdp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Authentification findByNom(@PathVariable final String login,@PathVariable final String mdp) {
	
		return authentificationService.findByLoginAndMdp(login, mdp);
	}
	
	

}

