package com.equipe4.GeoPatrimoine1.service;

import com.equipe4.GeoPatrimoine1.entity.PatrimoineHistorique;
import com.equipe4.GeoPatrimoine1.repository.PatrimoineHistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatrimoineHistoriqueService {

    @Autowired
    private PatrimoineHistoriqueRepository patrimoineHistoriqueRepository;

    public List<PatrimoineHistorique>  findAll(){
        return patrimoineHistoriqueRepository.findAll();
    }
	
	public PatrimoineHistorique  findById(Long id){
        return patrimoineHistoriqueRepository.getOne(id);

    }
	
	 public List<PatrimoineHistorique>  findByNom(String nom) {
        return patrimoineHistoriqueRepository.findByNomIgnoreCase(nom);
    }

    public PatrimoineHistorique creerPatrimoineHistorique(PatrimoineHistorique ph) {
        return patrimoineHistoriqueRepository.save(ph);
    }

    public void deletePatrimoineHistorique(Long id){
        patrimoineHistoriqueRepository.deleteById(id);
    }
}
