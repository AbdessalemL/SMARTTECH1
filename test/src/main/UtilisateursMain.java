/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Service.ServiceUtilisateurs;
import entity.Utilisateurs;

public class UtilisateursMain {
   public static void main(String[] args) {
        ServiceUtilisateurs us = new ServiceUtilisateurs();

        // Create a new Utilisateurs (User)
        Utilisateurs u = new Utilisateurs("Said", "Brahmi", "1234", "said.brahmi@esprit.tn", "client");
        us.ajouterUser(u);
        Utilisateurs b = new Utilisateurs("wifek", "arfaoui", "wifek123", "wifek.arfaoui@esprit.tn", "client");
        us.ajouterUser(b);

        // Update a Utilisateurs (User)
        Utilisateurs userToUpdate = new Utilisateurs();
        userToUpdate.setId(2);
        userToUpdate.setNom("wifek");
        userToUpdate.setPrenom("arfaoui");
        userToUpdate.setmdp("wifek123");
        userToUpdate.setemail("wifek.arfaoui@esprit.tn");
        userToUpdate.setRole("client");
        us.modifierUser(userToUpdate);

        // Delete a Utilisateurs (User)
        // Utilisateurs userToDelete = new Utilisateurs();
        // userToDelete.setId(1);
        // us.deleteUser(userToDelete);

        // Display Users
        System.out.println(us.afficherUser());
    }
}