package com.equipe4.GeoPatrimoine1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.equipe4.GeoPatrimoine1.entity.PatrimoineHistorique;
import com.equipe4.GeoPatrimoine1.repository.PatrimoineHistoriqueRepository;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class PatrimoineHistoriqueService {

    @Autowired
    private PatrimoineHistoriqueRepository patrimoineHistoriqueRepository;

    public List<PatrimoineHistorique>  findAll(){
        return patrimoineHistoriqueRepository.findAll();
    }
    
    public PatrimoineHistorique  findById(Long id){
        return patrimoineHistoriqueRepository.findOneById(id);
    }
    
    
    
    public List<PatrimoineHistorique>  findByTag(String nom) {
    	final String chaine = "%"+nom+"%";
        return patrimoineHistoriqueRepository.findByNomLikeIgnoreCase(chaine);
    }

    public PatrimoineHistorique creerPatrimoineHistorique(PatrimoineHistorique ph) {
        return patrimoineHistoriqueRepository.save(ph);
    }

    public void deletePatrimoineHistorique(Long id){
        patrimoineHistoriqueRepository.deleteById(id);
    }
}
