package main;

import java.sql.SQLException;
import java.util.List;
import entity.Livraison;
import Service.LivraisonService;

public class LivraisonMain {

    public static void main(String[] args) {
        LivraisonService livraisonService = new LivraisonService();

        // Create a new Livraison
        Livraison newLivraison = new Livraison("EYA", "mrad", "123 Main St", 50, 2);
        try {
            livraisonService.ajouterLivraison(newLivraison);
            System.out.println("Livraison added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding Livraison.");
        }

        // Retrieve all Livraisons
        try {
            List<Livraison> allLivraisons = livraisonService.getAllLivraisons();
            System.out.println("All Livraisons:");
            allLivraisons.forEach((livraison) -> {
                System.out.println(livraison);
            });
        } catch (SQLException e) {
            System.out.println("Error retrieving Livraisons.");
        }

        // Modify a Livraison
        
        Livraison updatedLivraison = new Livraison(1, "eya", "mrad", "456 Elm St", 60, 3);
        try {
            livraisonService.modifierLivraison(updatedLivraison);
            System.out.println("Livraison modified successfully.");
        } catch (SQLException e) {
            System.out.println("Error modifying Livraison.");
        }

        // Delete a Livraison
        
        int livraisonIdToDelete = 4; 
        try {
            livraisonService.supprimerLivraison(livraisonIdToDelete);
            System.out.println("Livraison deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting Livraison.");
        }
    }
}



 

    

    
