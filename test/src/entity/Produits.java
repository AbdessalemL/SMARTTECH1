/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Produits {
    private int product_id;
    private float prix;
    private String description;
    private String nom_produit;
    private URL image;

    public Produits() {
    }

    public Produits(float prix, String description, String nom_produit) {
        this.prix = prix;
        this.description = description;
        this.nom_produit = nom_produit;
    }

    public Produits(float prix, String description, String nom_produit, URL image) {
        this.prix = prix;
        this.description = description;
        this.nom_produit = nom_produit;
        this.image = image;
    }

    public Produits(int product_id, float prix, String description, String nom_produit) {
        this.product_id = product_id;
        this.prix = prix;
        this.description = description;
        this.nom_produit = nom_produit;
    }

    // Getter and setter methods
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    // Optional: If you want to return a list of products, implement this method
    public static ObservableList<Produits> getSampleProducts() {
        ObservableList<Produits> products = FXCollections.observableArrayList();
        products.add(new Produits(1, 10.0f, "Description 1", "Product 1"));
        products.add(new Produits(2, 20.0f, "Description 2", "Product 2"));
        // Add more products as needed
        return products;
    }

    public Object prixProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void descriptionProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void nom_produitProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdP(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
