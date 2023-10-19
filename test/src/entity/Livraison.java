/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author 
 */
public class Livraison {
    private int idLivraison;
    private String nom, prenom, adresse;
    private int prix;
    private int nbre_commandes;

    public Livraison(String nom, String prenom, String adresse, int prix, int nbre_commandes) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.prix = prix;
        this.nbre_commandes = nbre_commandes;
    }

    public Livraison(int idLivraison, String nom, String prenom, String adresse, int prix, int nbre_commandes) {
        this.idLivraison = idLivraison;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.prix = prix;
        this.nbre_commandes = nbre_commandes;
    }

    public Livraison(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Livraison() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbreCommandes() {
        return nbre_commandes;
    }

    public void setNbreCommandes(int nbre_commandes) {
        this.nbre_commandes = nbre_commandes;
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "idLivraison=" + idLivraison +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", prix=" + prix +
                ", nbre_commandes=" + nbre_commandes +
                '}';
    }
}
