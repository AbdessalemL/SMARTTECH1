package main;

import Service.PanierService;
import entity.Panier;
import entity.Produits;
import entity.Utilisateurs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanierMain {

    public static void main(String[] args) throws SQLException {
        PanierService panierService = new PanierService();

        // Create a new Utilisateurs
        Utilisateurs utilisateur = new Utilisateurs(1, "sampleUser", "achref", "achref@gmail.com", "password123", "customer");

        // Create a list of cart items (Produits objects)
        List<Produits> cartItems = new ArrayList<>();
        Produits item1 = new Produits(1, 25.0f, "Product 1 description", "Product 1");
        Produits item2 = new Produits(2, 15.0f, "Product 2 description", "Product 2");
        cartItems.add(item1);
        cartItems.add(item2);

        // Create a new Panier
        Panier newPanier = new Panier(cartItems, utilisateur);
        panierService.createPanier(newPanier);
        System.out.println("Panier created successfully.");

        // Retrieve a Panier by its ID
        try {
            int panierIdToRetrieve = 1;
            Panier retrievedPanier = panierService.getPanierById(panierIdToRetrieve);
            System.out.println("Retrieved Panier:");
            System.out.println(retrievedPanier);
        } catch (SQLException e) {
            System.out.println("Error retrieving Panier: " + e.getMessage());
        }

        // Update an existing Panier
        int panierIdToUpdate = 6;
        Panier updatedPanier = new Panier(cartItems, utilisateur, panierIdToUpdate);
        panierService.updatePanier(updatedPanier);
        System.out.println("Panier updated successfully.");

        // Delete a Panier by its ID
        int panierIdToDelete = 7;
        panierService.deletePanier(panierIdToDelete);
        System.out.println("Panier deleted successfully.");
    }
}
