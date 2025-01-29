package Views;
import javax.swing.*;

import Models.entities.Banquier;
import Controllers.BanqueController;
import Controllers.BanquierController;
import Controllers.DirecteurController;
import Models.entities.Client;
import utils.Session;
import Controllers.ClientController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ViewDirecteur extends JFrame {

    public ViewDirecteur() {




        // Configuration de la fenêtre
        setTitle("E-KOUDI BANK");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Position absolue pour un contrôle total des éléments

        // Ajout d'une image de fond
        JLabel background = new JLabel(new ImageIcon("/Ressource/BANK2.jpg")); // Assurez-vous que BANK2.jpg est dans le même dossier
        background.setBounds(0, 0, 1500, 1000);
        add(background);

        // Création du header
        JLabel title = new JLabel("Espace Directeur", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 20, 1500, 50); // Positionnement et dimensions
        background.add(title);

        // Barre de navigation
        JPanel navbar = new JPanel();
        navbar.setOpaque(false); // Rendre transparent pour afficher l'image de fond
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        navbar.setBounds(0, 100, 1500, 70); // Positionnement

        // Boutons de navigation
        JButton btnGerer = createButton("Gerer les Banquiers");
        JButton btnAllBanquiers = createButton("Tous les Banquiers ");
        JButton btnAllClients = createButton("Tous les Clients ");
        JButton btnModifier = createButton("Modifier mes infos");
        JButton btnRetour = createButton("Retour");
        JButton btnInfoBank= createButton("Infos de la banque");

        navbar.add(btnGerer);
        navbar.add(btnAllBanquiers);
        navbar.add(btnAllClients);
        navbar.add(btnInfoBank);
        navbar.add(btnModifier);
        navbar.add(btnRetour);

        background.add(navbar);

        // Ligne de séparation sous les boutons
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(100, 170, 1300, 3); // Ligne fine blanche
        background.add(separator);
        btnInfoBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenir les données du résumé via le contrôleur
                String resume = BanqueController.infosBanque();

                // Afficher les informations dans une boîte de dialogue
                JOptionPane.showMessageDialog(
                        ViewDirecteur.this, // Parent de la boîte de dialogue
                        resume,             // Message à afficher
                        "Résumé de la Banque", // Titre de la boîte de dialogue
                        JOptionPane.INFORMATION_MESSAGE // Type d'icône
                );
            }
        });
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de Modification pour le Directeur
                JTextField nomField = new JTextField(20);
                JTextField prenomField = new JTextField(20);
                JTextField dateNaisField = new JTextField(20);
                JTextField cinField = new JTextField(20);
                JTextField telField = new JTextField(20);
                JTextField adresseField = new JTextField(20);
                JTextField mailField = new JTextField(20);
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(10, 2));
                loginPanel.setBackground(new Color(30, 60, 120)); // Fond bleu foncé

                JLabel nomLabel = new JLabel("Nom :");
                nomLabel.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(nomLabel);
                loginPanel.add(nomField);

                JLabel prenomLabel = new JLabel("Prenom:");
                prenomLabel.setForeground(Color.WHITE);
                loginPanel.add(prenomLabel);
                loginPanel.add(prenomField);

                JLabel dateNaisLabel = new JLabel("Date de naissance:");
                dateNaisLabel.setForeground(Color.WHITE);
                loginPanel.add(dateNaisLabel);
                loginPanel.add(dateNaisField);

                JLabel cinLabel = new JLabel("CIN:");
                cinLabel.setForeground(Color.WHITE);
                loginPanel.add(cinLabel);
                loginPanel.add(cinField);

                JLabel telLabel = new JLabel("TEL:");
                telLabel.setForeground(Color.WHITE);
                loginPanel.add(telLabel);
                loginPanel.add(telField);

                JLabel adresseLabel = new JLabel("Adresse:");
                adresseLabel.setForeground(Color.WHITE);
                loginPanel.add(adresseLabel);
                loginPanel.add(adresseField);

                JLabel mailLabel = new JLabel("Mail:");
                mailLabel.setForeground(Color.WHITE);
                loginPanel.add(mailLabel);
                loginPanel.add(mailField);

                JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
                usernameLabel.setForeground(Color.WHITE);
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);

                JLabel passwordLabel = new JLabel("Mot de passe:");
                passwordLabel.setForeground(Color.WHITE);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Modifications", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Session.getUserId();
                        boolean valid = DirecteurController.modifierDirecteur(
                                nomField.getText(),
                                prenomField.getText(),
                                dateNaisField.getText(),
                                cinField.getText(),
                                telField.getText(),
                                adresseField.getText(),
                                mailField.getText(),
                                usernameField.getText(),
                                new String(passwordField.getPassword()),
                                id
                        );
                        if (valid) {
                            JOptionPane.showMessageDialog(null, "Informations modifiées !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur de modification.");
                    }
                }
            }
        });


        // Action du bouton "Gerer les banquiers"
        btnGerer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose(); // Fermer la fenêtre actuelle
                new ViewGererBanquier().setVisible(true); // Ouvrir la fenêtre de gestion des banquiers
            }
        });


        //action du bouton "Retour"
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retour à l'accueil
                dispose(); // Fermer la fenêtre actuelle
                new AccueilPage().setVisible(true); // Ouvrir la fenêtre d'accueil
            }
        });
        btnAllBanquiers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Banquier> banquiers = BanquierController.getAllBanquier();
                new TableBanquiersView(banquiers).setVisible(true);
            }
        });
        btnAllClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Client> clients = ClientController.getAllClient();
                new TableClientsView(clients).setVisible(true);
            }
        });

    }

    /**
     * Méthode utilitaire pour créer un bouton stylisé
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(200, 40)); // Taille uniforme
        return button;
    }



}
