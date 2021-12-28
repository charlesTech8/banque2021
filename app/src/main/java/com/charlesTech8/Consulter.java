package com.charlesTech8;

import org.json.JSONObject;

public class Consulter {
    private String numeroCompte, nom, prenom, solde, etat;

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSolde() {
        return solde;
    }

    public String getEtat() {
        return etat;
    }

    public Consulter(JSONObject jObject){
        this.numeroCompte = jObject.optString("numeroCompte");
        this.nom = jObject.optString("nom");
        this.prenom = jObject.optString("prenom");
        this.solde = jObject.optString("solde");
        this.etat = jObject.optString("etat");
    }
}
