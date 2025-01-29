package Views;
import javax.swing.*;

import Controllers.BanqueController;
import Controllers.ClientController;
import Controllers.CompteCourantController;
import Controllers.CompteEpargneController;
import Models.entities.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewGererClient extends JFrame {
    public ViewGererClient() {
        // Configuration de la fenêtre
        setTitle("E-KOUDI BANK");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Position absolue pour un contrôle total des éléments

        // Ajout d'une image de fond
        JLabel background = new JLabel(new ImageIcon("/Ressource/BANK2.jpg"));
        background.setBounds(0, 0, 1500, 1000);
        add(background);

        // Création du header
        JLabel title = new JLabel("Gestion de Clients", SwingConstants.CENTER);
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
        JButton btnAjouter = createButton("Ajouter un Client");
        JButton btnSupprimer = createButton("supprimer un Client");
        JButton btnModifier = createButton("Set solde");
        JButton btnDepot = createButton("Depot");
        JButton btnRetour = createButton("Retour");

        navbar.add(btnAjouter);
        navbar.add(btnSupprimer);
        navbar.add(btnModifier);
        navbar.add(btnDepot);
        navbar.add(btnRetour);
        background.add(navbar);

        // Ligne de séparation sous les boutons
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(100, 170, 1300, 2); // Ligne fine blanche
        background.add(separator);

        // Action du bouton "Retour"
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retour à l'accueil
                dispose(); // Fermer la fenêtre actuelle
                new ViewBanquier().setVisible(true); // Ouvrir la fenêtre de directeur
            }
        });
        // Exemple complet
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de saisie des informations personnelles du client
                JTextField nomField = new JTextField(20);
                JTextField prenomField = new JTextField(20);
                JTextField dateNaisField = new JTextField(20);
                JTextField cinField = new JTextField(20);
                JTextField telField = new JTextField(20);
                JTextField adresseField = new JTextField(20);
                JTextField mailField = new JTextField(20);
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);

                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new GridLayout(10, 2));
                infoPanel.setBackground(new Color(30, 60, 120));

                JLabel[] labels = {
                        new JLabel("Nom :"), new JLabel("Prénom :"), new JLabel("Date de naissance :"),
                        new JLabel("CIN :"), new JLabel("Téléphone :"), new JLabel("Adresse :"),
                        new JLabel("E-mail :"), new JLabel("Nom d'utilisateur :"), new JLabel("Mot de passe :")
                };

                for (JLabel label : labels) {
                    label.setForeground(Color.WHITE);
                }

                infoPanel.add(labels[0]); infoPanel.add(nomField);
                infoPanel.add(labels[1]); infoPanel.add(prenomField);
                infoPanel.add(labels[2]); infoPanel.add(dateNaisField);
                infoPanel.add(labels[3]); infoPanel.add(cinField);
                infoPanel.add(labels[4]); infoPanel.add(telField);
                infoPanel.add(labels[5]); infoPanel.add(adresseField);
                infoPanel.add(labels[6]); infoPanel.add(mailField);
                infoPanel.add(labels[7]); infoPanel.add(usernameField);
                infoPanel.add(labels[8]); infoPanel.add(passwordField);

                int option = JOptionPane.showConfirmDialog(null, infoPanel, "Ajout d'un Client", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        // Création d'un nouveau client
                        Client client = new Client(
                                nomField.getText(), prenomField.getText(), dateNaisField.getText(), cinField.getText(),
                                telField.getText(), adresseField.getText(), mailField.getText(),
                                usernameField.getText(), new String(passwordField.getPassword())
                        );

                        // Validation et ajout du client
                        boolean clientAjoute = ClientController.ajouterClient(client);
                        int idClient=client.getId();

                        if (clientAjoute) {
                            // Choix du type de compte
                            JRadioButton compteCourant = new JRadioButton("Compte courant");
                            JRadioButton compteEpargne = new JRadioButton("Compte épargne");
                            ButtonGroup group = new ButtonGroup();
                            group.add(compteCourant);
                            group.add(compteEpargne);

                            JPanel choixPanel = new JPanel();
                            choixPanel.setLayout(new GridLayout(3, 1));
                            choixPanel.add(new JLabel("Choisissez le type de compte :"));
                            choixPanel.add(compteCourant);
                            choixPanel.add(compteEpargne);

                            int choix = JOptionPane.showConfirmDialog(null, choixPanel, "Type de Compte", JOptionPane.OK_CANCEL_OPTION);
                            if (choix == JOptionPane.OK_OPTION) {
                                // Demande de la date de création du compte
                                JTextField dateCreationField = new JTextField(20);
                                JPanel datePanel = new JPanel();
                                datePanel.setLayout(new GridLayout(2, 1));
                                datePanel.add(new JLabel("Entrez la date de création du compte :"));
                                datePanel.add(dateCreationField);

                                if (compteCourant.isSelected()) {
                                    int dateOption = JOptionPane.showConfirmDialog(null, datePanel, "Date de création", JOptionPane.OK_CANCEL_OPTION);
                                    if (dateOption == JOptionPane.OK_OPTION) {
                                        String dateCreation = dateCreationField.getText();
                                        boolean compteCree = CompteCourantController.creerCompteCourant(idClient, TypeCompte.COURANT, dateCreation);
                                        if (compteCree) {
                                            JOptionPane.showMessageDialog(null, "Nouveau client et compte courant créés avec succès !");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Erreur lors de la création du compte courant !");
                                        }
                                    }
                                } else if (compteEpargne.isSelected()) {
                                    JTextField dureeField = new JTextField(20);
                                    JPanel epargnePanel = new JPanel();
                                    epargnePanel.setLayout(new GridLayout(4, 1));
                                    epargnePanel.add(new JLabel("Entrez la date de création du compte :"));
                                    epargnePanel.add(dateCreationField);
                                    epargnePanel.add(new JLabel("Entrez la durée du compte épargne (en années) :"));
                                    epargnePanel.add(dureeField);

                                    int epargneOption = JOptionPane.showConfirmDialog(null, epargnePanel, "Compte Épargne", JOptionPane.OK_CANCEL_OPTION);
                                    if (epargneOption == JOptionPane.OK_OPTION) {
                                        String dateCreation = dateCreationField.getText();
                                        int duree = Integer.parseInt(dureeField.getText());
                                        boolean compteCree = CompteEpargneController.creerCompteEpargne(idClient, duree, TypeCompte.EPARGNE, dateCreation);
                                        if (compteCree) {
                                            JOptionPane.showMessageDialog(null, "Nouveau client et compte épargne créés avec succès !");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Erreur lors de la création du compte épargne !");
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Veuillez choisir un type de compte !");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Erreur : le client existe déjà !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur : données invalides !");
                    }

                }
            }
        });

        btnSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField(20);

                JPanel deletePanel = new JPanel();
                deletePanel.setLayout(new GridLayout(1, 2));
                deletePanel.setBackground(new Color(30, 60, 120));

                JLabel idLabel = new JLabel("ID :");
                idLabel.setForeground(Color.WHITE);

                deletePanel.add(idLabel);
                deletePanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, deletePanel, "Suppression d'un Client", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String idText = idField.getText().trim();  // Récupérer l'ID du client
                    if (!idText.isEmpty()) {
                        try {
                            int idClient = Integer.parseInt(idText);  // Convertir en entier

                            // Appeler la méthode supprimerClient dans BanqueController
                            boolean success = BanqueController.supprimerClient(idClient);

                            // Afficher un message selon le résultat de la suppression
                            if (success) {
                                JOptionPane.showMessageDialog(null, "Client supprimé avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Echec de la suppression du client", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un ID valide", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Veuillez entrer un ID de client", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField salaireField = new JTextField(20);
                JTextField idField = new JTextField(20);

                JPanel modifyPanel = new JPanel();
                modifyPanel.setLayout(new GridLayout(2, 2));
                modifyPanel.setBackground(new Color(30, 60, 120));

                JLabel salaireLabel = new JLabel("Nouveau Solde :");
                JLabel idLabel = new JLabel("ID Client :");

                salaireLabel.setForeground(Color.WHITE);
                idLabel.setForeground(Color.WHITE);

                modifyPanel.add(salaireLabel);
                modifyPanel.add(salaireField);
                modifyPanel.add(idLabel);
                modifyPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, modifyPanel, "Modification du solde", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        double salaire = Double.parseDouble(salaireField.getText());
                        int idc = Integer.parseInt(idField.getText());
                        CompteBancaire compte = BanqueController.getCompteBancaire(idc); // Appel unique pour récupérer le compte

                        if (compte != null) {
                            int id = compte.getIdCompte();
                            boolean valid=false;
                            if(compte instanceof CompteCourant) {
                                valid=CompteCourantController.modifierSolde(salaire, id); // Utilisation de la méthode modifierSolde pour tous les types de compte
                            }
                            else if(compte instanceof CompteEpargne){
                                valid=CompteEpargneController.modifierSolde(salaire, id);
                            }
                            if (valid) {
                                JOptionPane.showMessageDialog(null, "Solde modifié !");
                                // Logique de redirection ou d'ouverture de la fenêtre
                            } else {
                                JOptionPane.showMessageDialog(null, "Données incorrectes !");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Compte non trouvé !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                    }


                }
            }
        });

        btnDepot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField montantField = new JTextField(20);
                JTextField idField = new JTextField(20);

                JPanel depotPanel = new JPanel();
                depotPanel.setLayout(new GridLayout(2, 2));
                depotPanel.setBackground(new Color(30, 60, 120));

                JLabel montantLabel = new JLabel("Montant :");
                JLabel idLabel = new JLabel("ID Client :");

                montantLabel.setForeground(Color.WHITE);
                idLabel.setForeground(Color.WHITE);

                depotPanel.add(montantLabel);
                depotPanel.add(montantField);
                depotPanel.add(idLabel);
                depotPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, depotPanel, "Dépôt d'argent", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        double salaire = Double.parseDouble(montantField.getText());
                        int idc = Integer.parseInt(idField.getText());
                        CompteBancaire compte = BanqueController.getCompteBancaire(idc); // Appel unique pour récupérer le compte

                        if (compte != null) {
                            int id = compte.getIdCompte();
                            boolean valid=false;
                            if(compte instanceof CompteCourant) {
                                valid=CompteCourantController.depotArgent(salaire,id); // Utilisation de la méthode modifierSolde pour tous les types de compte
                            }
                            else if(compte instanceof CompteEpargne){
                                valid=CompteEpargneController.depotArgent(salaire,id);
                            }
                            if (valid) {
                                JOptionPane.showMessageDialog(null, "Montant ajouté !");
                                // Logique de redirection ou d'ouverture de la fenêtre
                            } else {
                                JOptionPane.showMessageDialog(null, "Données incorrects !");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Compte non trouvé !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                    }

                }
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
