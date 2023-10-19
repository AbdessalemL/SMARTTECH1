/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.LivraisonService;
import entity.Livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class LivraisonFXMLController implements Initializable {

    @FXML
    private Button AjouterLivreur;
    @FXML
    private Button modifierButton;
    @FXML
    private Button Supprimerbutton;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Prix;
    @FXML
    private Spinner<Integer> Spinner; // Assuming you want an Integer spinner
    @FXML
    private SplitMenuButton SplitMenuButtonAdresse;
    @FXML
    private Label testLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AjouterLivreur.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LivraisonService ls = new LivraisonService();
                String nom = Nom.getText();
                String prenom = Prenom.getText();
                int prix = Integer.parseInt(Prix.getText());
                int quantity = Spinner.getValue(); // Assuming you want to get the selected spinner value

                Livraison livraison;
                livraison = new Livraison();

                try {
                    ls.ajouterLivraison(livraison);

                    // Refresh the scene by loading it again
                    Parent root = FXMLLoader.load(getClass().getResource("LivraisonFXML.fxml"));
                    Nom.getScene().setRoot(root);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(LivraisonFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private void btnModifierClicked(ActionEvent event) {
       
    }

    @FXML
    private void btnSupprimerClicked(ActionEvent event) {
        
    }
}
