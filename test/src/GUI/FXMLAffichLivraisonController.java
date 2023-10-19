/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.LivraisonService;
import entity.Livraison;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLAffichLivraisonController implements Initializable {

    @FXML
    private TableView<Livraison> TableView;
    @FXML
    private TableColumn<Livraison, String> NomCol;
    @FXML
    private TableColumn<Livraison, String> PrenomCol;
    @FXML
    private TableColumn<Livraison, String> AdresseCol;
    @FXML
    //private TableColumn<Livraison, int> PrixCol;
   // @FXML
    //private TableColumn<Livraison, int> NombreCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LivraisonService ls = new LivraisonService();
        try {
            ArrayList<Livraison> arrayList;
            arrayList = (ArrayList<Livraison>) ls.getAllLivraisons();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            TableView.setItems(obs);

            NomCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            PrenomCol.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            AdresseCol.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAffichLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
