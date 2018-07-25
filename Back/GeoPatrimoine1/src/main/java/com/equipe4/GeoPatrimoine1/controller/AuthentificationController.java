package com.equipe4.GeoPatrimoine1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.equipe4.GeoPatrimoine1.entity.AuthRetour;
import com.equipe4.GeoPatrimoine1.entity.Utilisateur;
import com.equipe4.GeoPatrimoine1.service.UtilisateurService;


/**
 * Ressource REST pour l'entit� Authentification.
 */
@RestController
@RequestMapping(value = "/api")
public class AuthentificationController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	/**
	 * GET /patrimoineHistorique -> récupérer tous les administrateurs .
	 *
	 * @return la liste des administrateur
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Utilisateur> findAllUsers() {
		return utilisateurService.findAll();
	}
	
	/**
	 * GET /admin/:id -> récupérer l'administrateur par son id.
	 *
	 * @param id de l'administrateur
	 * @return l'administrateur
	 */
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur findById(@PathVariable final Long id) {
		return utilisateurService.findById(id);
	}
	
	/**
	 * GET /admin/:login, mdp -> récupérer l'administrateur par la combinaison de son login et mdm.
	 *
	 * @param login de l'administrateur, mdp de l'administrateur
	 * @return une combinaison message et code : "OK" et 1 si l'utilisateur est reconnu, "KO" et 0 dans le cas contraire
	 */
	@RequestMapping(value = "/admin/auth", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthRetour findByNom(@RequestParam("utilisateur") final String login,@RequestParam("motDePasse") final String mdp) {
		
		final Utilisateur utilisateur = utilisateurService.findByLoginAndMdp(login, mdp);
		final AuthRetour authRetour = new AuthRetour();
		authRetour.setMessage("KO");
		authRetour.setCode(0);
		if (utilisateur != null) {
			authRetour.setMessage("OK");
			authRetour.setCode(1);	
		}
		
		return authRetour;
		
	}
	
	

}

