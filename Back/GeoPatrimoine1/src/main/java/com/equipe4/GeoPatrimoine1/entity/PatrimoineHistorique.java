package com.equipe4.GeoPatrimoine1.entity;

import javax.persistence.*;

@Entity
public class PatrimoineHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "horaires")
    private String horaires;

    @Column(name = "telephone")

    private Long telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "codePostal")
    private String codePostal;

    @Column(name = "commune")
    private String commune;

    @Column(name = "tarif")
    private Double tarif;

    @Column(name = "tarifMin")
    private Double tarifMin;

    @Column(name = "tarifMax")
    private Double tarifMax;

    @Column(name = "geoTag")
    private String geoTag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public Double getTarifMin() {
        return tarifMin;
    }

    public void setTarifMin(Double tarifMin) {
        this.tarifMin = tarifMin;
    }

    public Double getTarifMax() {
        return tarifMax;
    }

    public void setTarifMax(Double tarifMax) {
        this.tarifMax = tarifMax;
    }

    public String getGeoTag() {
        return geoTag;
    }

    public void setGeoTag(String geoTag) {
        this.geoTag = geoTag;
    }

}
