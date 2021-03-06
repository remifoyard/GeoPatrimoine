package com.equipe4.GeoPatrimoine1.entity;

import javax.persistence.*;

@Entity
public class PatrimoineHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

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
    private String tarif;

    @Column(name = "tarifMin")
    private String tarifMin;

    @Column(name = "tarifMax")
    private String tarifMax;

    @Column(name = "geoTag")
    private String geoTag;

    @Column(name = "lienImage")
    private String lienImage;

    @Column(name = "lienAudio")
    private String lienAudio;

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

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getTarifMin() {
        return tarifMin;
    }

    public void setTarifMin(String tarifMin) {
        this.tarifMin = tarifMin;
    }

    public String getTarifMax() {
        return tarifMax;
    }

    public void setTarifMax(String tarifMax) {
        this.tarifMax = tarifMax;
    }

    public String getGeoTag() {
        return geoTag;
    }

    public void setGeoTag(String geoTag) {
        this.geoTag = geoTag;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    public String getLienAudio() {
        return lienAudio;
    }

    public void setLienAudio(String lienAudio) {
        this.lienAudio = lienAudio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
