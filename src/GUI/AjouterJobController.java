/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.enities.Category;
import esprit.enities.Job;
import esprit.services.CategoryService;
import esprit.services.JobService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mznou
 */
public class AjouterJobController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private ComboBox<String> cat_cb;
    @FXML
    private TextField fx_type;
    @FXML
    private TextField fx_metier;
    @FXML
    private TextArea fx_desc;
    @FXML
    private ImageView imagev;
    @FXML
    private Label file_path;
    
    Job article = new Job();
    JobService ss = new JobService();
    @FXML
    private AnchorPane nh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //GET CATREGORIES LISTE DEROULANTE FOR JOIN !
                        ObservableList<String>list = FXCollections.observableArrayList();
                        CategoryService sc = new CategoryService();
                        
                        
                      
                        ObservableList<Category>obList = FXCollections.observableArrayList();
                        obList =sc.afficherCategory2();

        cat_cb.getItems().clear();
        
        for(Category nameCat : obList) {
            System.out.println("hii");
            list.add(nameCat.getNomCategorie());
                        System.out.println(list);

                    cat_cb.setItems(list);

        }
    }    

    @FXML
    private void ajoutJobHandle(ActionEvent event) {
        
        

        String type = fx_type.getText();
        String metierOuProduit = fx_metier.getText();
          String  description=fx_desc.getText();
     

       if (type.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Erreur! Veuillez entrer type !");
            alert.show();
        } else if (metierOuProduit.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Erreur! Veuillez entrer metierOuProduit !");
            alert.show();
        } else if (description.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Erreur! Veuillez entrer description !");
            alert.show();


        } else {
            ss.ajouterJob(new Job(type, metierOuProduit, description, file_path.getText(),cat_cb.getValue()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success Message");
            alert.setHeaderText(null);
            alert.setContentText("Job ajouté avec succés !");
            alert.showAndWait();

    }

 
        
        
    }

    @FXML
    private void uploadimageHandler(MouseEvent event) {
        FileChooser open = new FileChooser();
        Stage stage = (Stage) nh.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null) {
            String path = file.getName();
            file_path.setText(path);
            Image image = new Image(file.toURI().toString(), 110, 110, false, true);
            imagev.setImage(image);
        } else {
            System.out.println("NO DATA EXIST!");
        }
    }
    

    @FXML
    private void ajoutJobHandler(ActionEvent event) {
        try {
            Parent page1 = FXMLLoader.load(getClass().getResource("AfficherArticle.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
