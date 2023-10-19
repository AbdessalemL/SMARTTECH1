package Service;

import DB.MyDB;
import entity.Panier;
import entity.Produits;
import entity.Utilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanierService {

    Connection connexion;

    public PanierService() {
        connexion = MyDB.getInstance().getConnection();
    }

    public Panier getPanierById(int panierId) throws SQLException {
        Utilisateurs utilisateur = null;
        List<Produits> cartItems = new ArrayList<>();

        // Retrieve Utilisateurs information based on panier_id
        String utilisateurQuery = "SELECT * FROM utilisateur_cart_items WHERE panier_id = ?";
        try (PreparedStatement utilisateurStatement = connexion.prepareStatement(utilisateurQuery)) {
            utilisateurStatement.setInt(1, panierId);
            ResultSet utilisateurResult = utilisateurStatement.executeQuery();
            if (utilisateurResult.next()) {
                int userId = utilisateurResult.getInt("utilisateur_id");
                utilisateur = getUtilisateursById(userId);
            }
        }

        // Retrieve cart items based on panier_id
        String cartItemsQuery = "SELECT * FROM cart_items WHERE panier_id = ?";
        try (PreparedStatement cartItemsStatement = connexion.prepareStatement(cartItemsQuery)) {
            cartItemsStatement.setInt(1, panierId);
            ResultSet cartItemsResult = cartItemsStatement.executeQuery();
            while (cartItemsResult.next()) {
                int productId = cartItemsResult.getInt("id_produit");
                Produits produit = getProductById(productId);
                cartItems.add(produit);
            }
        }

        return new Panier(cartItems, utilisateur, panierId);
    }

    private Utilisateurs getUtilisateursById(int userId) {
        Utilisateurs utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE id = ?";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("nom");
                String email = resultSet.getString("email");

                // Create a Utilisateurs object
                utilisateur = new Utilisateurs(id, username, email, "", ""); // Provide appropriate values for the missing parameters
            }
        } catch (SQLException e) {
            // Handle the exception as needed
        }

        return utilisateur;
    }

    private Produits getProductById(int productId) {
        Produits produit = null;
        String sql = "SELECT * FROM produits WHERE idP = ?";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idP = resultSet.getInt("idP");
                float prix = resultSet.getFloat("prix");
                String description = resultSet.getString("description");
                String nom_produit = resultSet.getString("nom_produit");
                // Add more fields as needed

                // Create a Produits object
                produit = new Produits(prix, description, nom_produit);
                produit.setIdP(idP);
            }
        } catch (SQLException e) {

        }

        return produit;
    }

    public void createPanier(Panier newPanier) throws SQLException {
        // Insert the newPanier object into the database
        String insertPanierQuery = "INSERT INTO paniers (utilisateur_id) VALUES (?)";
        try (PreparedStatement insertStatement = connexion.prepareStatement(insertPanierQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, newPanier.getUtilisateur().getId());
            insertStatement.executeUpdate();

            // Retrieve the generated panier_id
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int panierId = generatedKeys.getInt(1);
                newPanier.setPanierId(panierId); // Update the newPanier object with the generated ID
            }
        }

        // Insert the cart items into the cart_items table
        String insertCartItemsQuery = "INSERT INTO cart_items (panier_id, id_produit) VALUES (?, ?)";
        try (PreparedStatement insertCartItemsStatement = connexion.prepareStatement(insertCartItemsQuery)) {
            int panierId = newPanier.getPanierId();
            for (Produits produit : newPanier.getCartItems()) {
                insertCartItemsStatement.setInt(1, panierId);
                insertCartItemsStatement.setInt(2, produit.getProduct_id());
                insertCartItemsStatement.executeUpdate();
            }
        }
    }

    public void updatePanier(Panier updatedPanier) throws SQLException {
        // Update the panier information in the database
        String updatePanierQuery = "UPDATE paniers SET utilisateur_id = ? WHERE panier_id = ?";
        try (PreparedStatement updateStatement = connexion.prepareStatement(updatePanierQuery)) {
            updateStatement.setInt(1, updatedPanier.getUtilisateur().getId());
            updateStatement.setInt(2, updatedPanier.getPanierId());
            updateStatement.executeUpdate();
        }

        // Delete existing cart items for the panier
        String deleteCartItemsQuery = "DELETE FROM cart_items WHERE panier_id = ?";
        try (PreparedStatement deleteCartItemsStatement = connexion.prepareStatement(deleteCartItemsQuery)) {
            deleteCartItemsStatement.setInt(1, updatedPanier.getPanierId());
            deleteCartItemsStatement.executeUpdate();
        }

        // Insert updated cart items into the cart_items table
        String insertCartItemsQuery = "INSERT INTO cart_items (panier_id, id_produit) VALUES (?, ?)";
        try (PreparedStatement insertCartItemsStatement = connexion.prepareStatement(insertCartItemsQuery)) {
            int panierId = updatedPanier.getPanierId();
            for (Produits produit : updatedPanier.getCartItems()) {
                insertCartItemsStatement.setInt(1, panierId);
                insertCartItemsStatement.setInt(2, produit.getProduct_id());
                insertCartItemsStatement.executeUpdate();
            }
        }
    }

    public void deletePanier(int panierIdToDelete) throws SQLException {
        // Delete the panier and associated cart items from the database
        String deleteCartItemsQuery = "DELETE FROM cart_items WHERE panier_id = ?";
        try (PreparedStatement deleteCartItemsStatement = connexion.prepareStatement(deleteCartItemsQuery)) {
            deleteCartItemsStatement.setInt(1, panierIdToDelete);
            deleteCartItemsStatement.executeUpdate();
        }

        String deletePanierQuery = "DELETE FROM paniers WHERE panier_id = ?";
        try (PreparedStatement deletePanierStatement = connexion.prepareStatement(deletePanierQuery)) {
            deletePanierStatement.setInt(1, panierIdToDelete);
            deletePanierStatement.executeUpdate();
        }
    }
}
