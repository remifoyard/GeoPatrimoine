package com.equipe4.GeoPatrimoine1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equipe4.GeoPatrimoine1.entity.PatrimoineHistorique;
import com.equipe4.GeoPatrimoine1.service.PatrimoineHistoriqueService;


/**
 * Ressource REST pour l'entit� PatrimoineHistorique.
 */
@RestController
@RequestMapping(value = "/api")
public class PatrimoineHistoriqueController {
	
	@Autowired
	private PatrimoineHistoriqueService patrimoineHistoriqueService;
	
	/**
	 * GET /patrimoineHistorique -> récupérer tous les points d'intérêts.
	 *
	 * @return la liste des points d'intérêts
	 */
	@RequestMapping(value = "/patrimoineHistorique", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PatrimoineHistorique> findAll() {
		//LOGGER.debug("Requête REST pour récupérer tous les points d'intérêts.");
		return patrimoineHistoriqueService.findAll();
	}
	
	/**
	 * GET /patrimoineHistorique/:id -> récupérer le point d'intérêt par son id.
	 *
	 * @param id du point d'intérêt
	 * @return le point d'intérêt
	 */
	@RequestMapping(value = "/patrimoineHistorique/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PatrimoineHistorique findById(@PathVariable final Long id) {
		//LOGGER.debug("Requête REST pour récupérer le point d'intérêt à partir de son id.");
		return patrimoineHistoriqueService.findById(id);
	}
	
	/**
	 * GET /patrimoineHistorique/:id -> récupérer le point d'intérêt par son id.
	 *
	 * @param id du point d'intérêt
	 * @return le point d'intérêt
	 */
	@RequestMapping(value = "/patrimoineHistoriqueTag/{tag}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PatrimoineHistorique> findByNom(@PathVariable final String tag) {
		//LOGGER.debug("Requête REST pour récupérer le point d'intérêt à partir d'une chaine de caractère à l'intérieur du nom.");
		return patrimoineHistoriqueService.findByTag(tag);
	}
	
	/**
	 * Delete
	 * GET /patrimoineHistorique/{id} -> delete by id
	 * @param id
	 */
	@RequestMapping(value="/patrimoineHistorique/delete/{id}", method = RequestMethod.GET)
	public void deleteById(@PathVariable final Long id) {
		patrimoineHistoriqueService.deletePatrimoineHistorique(id);
	}
	
	/**
	 * Save
	 * POST /patrimoineHistorique/save
	 * @param point d'intérêt
	 */
	@RequestMapping(value="/patrimoineHistorique/save", method = RequestMethod.POST)
    public void savePatrimoineHistorique(@RequestBody PatrimoineHistorique ph) {
		patrimoineHistoriqueService.creerPatrimoineHistorique(ph);
    }

}

