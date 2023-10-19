/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.SQLException;
import java.util.List;
import entity.Produits; // Change import to the Produits class
import Service.ProduitsService; // Change import to the ProduitsService class

public class ProduitsMain {

    public static void main(String[] args) {
        ProduitsService produitsService = new ProduitsService();

        // Create a new Produits (Product)
        Produits newProduit = new Produits(100.0f, "New Product Description", "New Product Name");
        try {
            produitsService.ajouterProduit(newProduit);
            System.out.println("Produit added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding Produit.");
        }

        // Retrieve all Produits (Products)
        try {
            List<Produits> allProduits = produitsService.getAllProduits();
            System.out.println("All Produits:");
            allProduits.forEach((produit) -> {
                System.out.println(produit);
            });
        } catch (SQLException e) {
            System.out.println("Error retrieving Produits.");
        }

        // Modify a Produits (Product)
        // Let's assume you have a Produits object with updated information
      Produits updatedProduit = new Produits(150.0f, "Updated Product Description", "Updated Product Name");
        try {
            produitsService.modifierProduit(updatedProduit);
            System.out.println("Produit modified successfully.");
        } catch (SQLException e) {
            System.out.println("Error modifying Produit.");
        }

        // Delete a Produits (Product)
        // Let's assume you want to delete a Produits with ID 2
        int produitIdToDelete = 2; // Replace with the actual ID you want to delete
        try {
            produitsService.supprimerProduit(produitIdToDelete);
            System.out.println("Produit deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting Produit.");
        }
    }
}
