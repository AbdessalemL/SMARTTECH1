/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Category;
import esprit.services.CategoryService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class AffichercategorieController implements Initializable {

    @FXML
    private ListView<Category> affichercategorie;


    
     static int IdCategorie;
   static String NomCategorie;
   static String DescriptionCategorie;
    @FXML
    private Button supprimer;
    @FXML
    private Button mod;
    
  
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
ListView<Category> list1= affichercategorie;
        CategoryService inter = new CategoryService();
        List<Category> list2 = inter.afficher();
        for (int i = 0; i < list2.size(); i++) {
            Category C = list2.get(i);
            list1.getItems().add(C);

        }    }    

    @FXML
    private void supprimercategorie(ActionEvent event) {
    ListView<Category> list1 = affichercategorie;
        CategoryService inter = new CategoryService();
        int selectedIndex = list1.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Category A = list1.getSelectionModel().getSelectedItem();
            System.out.println(A.getIdCategorie());
            inter.supprimer_category(A.getIdCategorie());
            list1.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner un categorie à supprimer.");
        }

    }

    @FXML
    private void mod(ActionEvent event) {
        
           ListView<Category> list = affichercategorie;
        CategoryService inter = new CategoryService();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        Category A = list.getSelectionModel().getSelectedItem();
        
             IdCategorie=A.getIdCategorie();
   NomCategorie=A.getNomCategorie();
   DescriptionCategorie=A.getDescriptionCategorie();
    
    

        try {

            Parent page1
                    = FXMLLoader.load(getClass().getResource("Modifiercategorie.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Location_categoryController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    }
  