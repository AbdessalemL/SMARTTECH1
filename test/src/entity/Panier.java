/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity; // Make sure the correct package name is used

import java.util.List;

public class Panier {
    private List<Produits> cartItems; // List of products in the cart
    private double prixTotale; // Total price of items in the cart
    private Utilisateurs utilisateur; // User associated with the cart
    private int panierId; // Cart identifier
    private int quantity;

    /**
     *
     * @param cartItems
     * @param utilisateur
     * @param panierId
     */
    public Panier(List<Produits> cartItems, Utilisateurs utilisateur, int panierId) {
        this.cartItems = cartItems;
        this.utilisateur = utilisateur;
        this.panierId = panierId;
        this.prixTotale = calculateTotalPrice();
    }
    public Panier(List<Produits> cartItems, Utilisateurs utilisateur) {
        this.cartItems = cartItems;
        this.utilisateur = utilisateur;
        this.prixTotale = calculateTotalPrice();
    }

    public Panier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Getters and setters for the remaining attributes

    public List<Produits> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Produits> cartItems) {
        this.cartItems = cartItems;
    }

    public double getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(double prixTotale) {
        this.prixTotale = prixTotale;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getPanierId() {
        return panierId;
    }

    public void setPanierId(int panierId) {
        this.panierId = panierId;
    }

    // Calculate the total price of items in the cart
 private double calculateTotalPrice() {
    return cartItems.stream()
        .mapToDouble(item -> item.getPrix())
        .sum();
}

    public Object getUtilisateurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
