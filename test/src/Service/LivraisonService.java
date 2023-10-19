package Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Livraison;
import DB.MyDB;

public class LivraisonService {

    Connection connexion;

    public LivraisonService() {
        connexion = MyDB.getInstance().getConnection();
    }

    public void ajouterLivraison(Livraison livraison) throws SQLException {
        String req = "INSERT INTO `livraison` (`nom`, `prenom`, `adresse`, `prix`, `nbre_commandes`) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, livraison.getNom());
        ps.setString(2, livraison.getPrenom());
        ps.setString(3, livraison.getAdresse());
        ps.setInt(4, livraison.getPrix());
        ps.setInt(5, livraison.getNbreCommandes());
        ps.executeUpdate();
    }

    public List<Livraison> getAllLivraisons() throws SQLException {
        List<Livraison> livraisons = new ArrayList<>();
        String req = "SELECT * FROM livraison";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Livraison livraison = new Livraison(
                rst.getInt("idLivraison"),
                rst.getString("nom"),
                rst.getString("prenom"),
                rst.getString("adresse"),
                rst.getInt("prix"),
                rst.getInt("nbre_commandes")
            );
            livraisons.add(livraison);
        }
        return livraisons;
    }

    public void modifierLivraison(Livraison livraison) throws SQLException {
        String req = "UPDATE livraison SET nom=?, prenom=?, adresse=?, prix=?, nbre_commandes=? WHERE idLivraison=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, livraison.getNom());
        ps.setString(2, livraison.getPrenom());
        ps.setString(3, livraison.getAdresse());
        ps.setInt(4, livraison.getPrix());
        ps.setInt(5, livraison.getNbreCommandes());
        ps.setInt(6, livraison.getIdLivraison()); 
        ps.executeUpdate();
    }

    public void supprimerLivraison(int livraisonIdToDelete) throws SQLException {
        String req = "DELETE FROM livraison WHERE idLivraison=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, livraisonIdToDelete);
        ps.executeUpdate();
    }
}
