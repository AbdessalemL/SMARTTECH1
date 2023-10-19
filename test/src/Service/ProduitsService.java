/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Produits;
import DB.MyDB;

public class ProduitsService {

    Connection connexion;

    public ProduitsService() {
        connexion = MyDB.getInstance().getConnection();
    }

    public void ajouterProduit(Produits produit) throws SQLException {
        String req = "INSERT INTO `produits` (`prix`, `description`, `nom_produit`) VALUES (?, ?, ?)";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setFloat(1, produit.getPrix());
        ps.setString(2, produit.getDescription());
        ps.setString(3, produit.getNom_produit());
        ps.executeUpdate(); // Removed the attempt to set idP
    
    }

    public List<Produits> getAllProduits() throws SQLException {
        List<Produits> produitsList = new ArrayList<>();
        String req = "SELECT * FROM produits";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Produits produit = new Produits(
                rst.getFloat("prix"),
                rst.getString("description"),
                rst.getString("nom_produit")
            );
            produit.setIdP(rst.getInt("idP"));
            produitsList.add(produit);
        }
        return produitsList;
    }

    public void modifierProduit(Produits produit) throws SQLException {
        String req = "UPDATE produits SET prix=?, description=?, nom_produit=? WHERE id=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setFloat(1, produit.getPrix());
        ps.setString(2, produit.getDescription());
        ps.setString(3, produit.getNom_produit());
        ps.setInt(4, produit.getIdP()); // Use the ID to identify the record to update
        ps.executeUpdate();
    }

    public void supprimerProduit(int produitIdToDelete) throws SQLException {
        String req = "DELETE FROM produits WHERE id=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, produitIdToDelete);
        ps.executeUpdate();
    }
}
