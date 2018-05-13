package com.equipe4.GeoPatrimoine1.repository;

import com.equipe4.GeoPatrimoine1.entity.PatrimoineHistorique;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrimoineHistoriqueRepository extends JpaRepository<PatrimoineHistorique, Long> {
	
	PatrimoineHistorique findOneById(Long id);
	
	List<PatrimoineHistorique> findByNomLikeIgnoreCase(String nom);


}
