package org.example;

import javax.swing.*;
/*  String url = "jdbc:mysql://localhost:3306/banquedb";
        String user = "root";
        String password = "88778095";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }*/

import Models.entities.GestionBase;
import Views.AccueilPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        // Charger les données au démarrage de l'application
        GestionBase.loadDataFromDataBase();

        // Exécution du programme dans le thread Swing
        SwingUtilities.invokeLater(() -> {
            AccueilPage accueil = new AccueilPage();
            accueil.setVisible(true);
        });

        // Ajouter un Shutdown Hook pour sauvegarder les données à la fermeture
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Application en cours de fermeture... Mise à jour des données.");
            GestionBase.updateDataBase();
        }));
    }
}

