/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Produits;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductFXMLController implements Initializable {
    @FXML
    private TableView<Produits> tableView;

    @FXML
    private Button viewDetailsProduct;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create columns for the TableView
        TableColumn<Produits, Double> priceColumn = new TableColumn<>("Prix");
        TableColumn<Produits, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<Produits, URL> imageColumn = new TableColumn<>("Image");
        TableColumn<Produits, String> nomProduitColumn = new TableColumn<>("Nom Produit");

        // Set the cell value factories
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        nomProduitColumn.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));

        // Add columns to the TableView
        tableView.getColumns().addAll(priceColumn, descriptionColumn, imageColumn, nomProduitColumn);

        // Sample data - you can replace this with your actual data
        ObservableList<Produits> data = Produits.getSampleProducts();
        tableView.setItems(data);
    }
}
