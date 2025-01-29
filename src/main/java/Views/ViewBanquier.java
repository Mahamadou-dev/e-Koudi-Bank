package Views;
import javax.swing.*;
import Controllers.BanqueController;
import Controllers.BanquierController;
import Models.entities.Client;
import Models.entities.CompteBancaire;
import utils.Session;
import Controllers.ClientController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewBanquier extends JFrame {

    public ViewBanquier() {
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
        JLabel title = new JLabel("Espace Banquier", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE); // Texte en blanc
        title.setBounds(0, 20, 1500, 50); // Positionnement et dimensions
        background.add(title);

        // Barre de navigation
        JPanel navbar = new JPanel();
        navbar.setOpaque(false); // Rendre transparent pour afficher l'image de fond
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        navbar.setBounds(0, 100, 1500, 70); // Positionnement

        // Boutons de navigation
        JButton btnGerer = createButton("Gerer les Clients");
        JButton btnAllComptes = createButton("Tous les Comptes ");
        JButton btnAllClients = createButton("Tous les Clients ");
        JButton btnModifier = createButton("Modifier mes infos");
        JButton btnInfosClient = createButton("Infos Client");
        JButton btnRetour = createButton("Retour");

        navbar.add(btnGerer);
        navbar.add(btnAllComptes);
        navbar.add(btnAllClients);
        navbar.add(btnInfosClient);
        navbar.add(btnModifier);
        navbar.add(btnRetour);

        background.add(navbar);

        // Ligne de séparation sous les boutons
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(100, 170, 1300, 3); // Ligne fine blanche
        background.add(separator);

        btnInfosClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Demander l'identifiant du client
                String idClient = JOptionPane.showInputDialog(
                        ViewBanquier.this, // Parent de la boîte de dialogue
                        "Veuillez saisir l'identifiant du client :", // Message
                        "Recherche d'un client", // Titre de la boîte de dialogue
                        JOptionPane.QUESTION_MESSAGE // Type d'icône
                );

                // Si l'utilisateur clique sur "Annuler" ou ne saisit rien, arrêter l'exécution
                if (idClient == null || idClient.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            ViewBanquier.this,
                            "Identifiant non fourni !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                try {
                    // Obtenir les données du client via le contrôleur
                    Client C = ClientController.getClient(Integer.parseInt(idClient.trim()));
                    CompteBancaire Ct = BanqueController.getCompteBancaire(Integer.parseInt(idClient));
                    String resume = C.toString() /*0+ Ct.toString()*/;
                    // Vérifier si le client existe
                    if (resume == null || resume.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                ViewBanquier.this,
                                "Aucun client trouvé avec cet identifiant.",
                                "Erreur",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        // Afficher les informations du client
                        JOptionPane.showMessageDialog(
                                ViewBanquier.this,
                                resume, // Message à afficher
                                "Informations d'un client", // Titre de la boîte de dialogue
                                JOptionPane.INFORMATION_MESSAGE // Type d'icône
                        );
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            ViewBanquier.this,
                            "Identifiant invalide. Veuillez saisir un nombre.",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de Modification pour le Banquier
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
                loginPanel.setLayout(new GridLayout(22, 2));

                // Anciennes infos (en blanc)
                JLabel labelAncienInfos = new JLabel("Anciennes infos");
                labelAncienInfos.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelAncienInfos);
                loginPanel.add(new JLabel(""));

                // Anciennes informations avec texte blanc
                JLabel labelNom = new JLabel("Nom :");
                labelNom.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelNom);
                JLabel nomValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getNom());
                nomValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(nomValue);

                JLabel labelPrenom = new JLabel("Prenom :");
                labelPrenom.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelPrenom);
                JLabel prenomValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getPrenom());
                prenomValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(prenomValue);

                JLabel labelDateNais = new JLabel("Date de Naissance :");
                labelDateNais.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelDateNais);
                JLabel dateNaisValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getDateNais());
                dateNaisValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(dateNaisValue);

                JLabel labelCin = new JLabel("CIN :");
                labelCin.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelCin);
                JLabel cinValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getCIN());
                cinValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(cinValue);

                JLabel labelTel = new JLabel("TEL :");
                labelTel.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelTel);
                JLabel telValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getTel());
                telValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(telValue);

                JLabel labelAdresse = new JLabel("Adresse :");
                labelAdresse.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelAdresse);
                JLabel adresseValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getAdresse());
                adresseValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(adresseValue);

                JLabel labelMail = new JLabel("Mail :");
                labelMail.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelMail);
                JLabel mailValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getMail());
                mailValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(mailValue);

                JLabel labelUsername = new JLabel("Nom d'utilisateur :");
                labelUsername.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelUsername);
                JLabel usernameValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getUsername());
                usernameValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(usernameValue);

                JLabel labelPassword = new JLabel("Mot de passe :");
                labelPassword.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelPassword);
                JLabel passwordValue = new JLabel(BanquierController.getBanquier(Session.getUserId()).getPassword());
                passwordValue.setForeground(Color.WHITE); // Texte en blanc pour la valeur
                loginPanel.add(passwordValue);

                loginPanel.add(new JLabel(""));
                loginPanel.add(new JLabel(""));
                loginPanel.add(new JLabel(""));
                loginPanel.add(new JLabel(""));

                // Nouvelles infos (en blanc)
                JLabel labelNouvellesInfos = new JLabel("Nouvelles infos");
                labelNouvellesInfos.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelNouvellesInfos);
                loginPanel.add(new JLabel(""));

                // Nouvelles informations (Texte en blanc pour les labels)
                JLabel labelNomNew = new JLabel("Nom :");
                labelNomNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelNomNew);
                loginPanel.add(nomField);

                JLabel labelPrenomNew = new JLabel("Prenom :");
                labelPrenomNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelPrenomNew);
                loginPanel.add(prenomField);

                JLabel labelDateNaisNew = new JLabel("Date de naissance :");
                labelDateNaisNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelDateNaisNew);
                loginPanel.add(dateNaisField);

                JLabel labelCinNew = new JLabel("CIN :");
                labelCinNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelCinNew);
                loginPanel.add(cinField);

                JLabel labelTelNew = new JLabel("TEL :");
                labelTelNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelTelNew);
                loginPanel.add(telField);

                JLabel labelAdresseNew = new JLabel("Adresse :");
                labelAdresseNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelAdresseNew);
                loginPanel.add(adresseField);

                JLabel labelMailNew = new JLabel("Mail :");
                labelMailNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelMailNew);
                loginPanel.add(mailField);

                JLabel labelUsernameNew = new JLabel("Nom d'utilisateur :");
                labelUsernameNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelUsernameNew);
                loginPanel.add(usernameField);

                JLabel labelPasswordNew = new JLabel("Mot de passe :");
                labelPasswordNew.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(labelPasswordNew);
                loginPanel.add(passwordField);

                // Affichage du panneau dans une fenêtre de dialogue
                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Modifier mes infos", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Session.getUserId();
                        boolean valid = BanquierController.modifierBanquier(
                                nomField.getText(),
                                prenomField.getText(),
                                dateNaisField.getText(),
                                cinField.getText(),
                                telField.getText(),
                                adresseField.getText(),
                                mailField.getText(),
                                usernameField.getText(),
                                new String(passwordField.getPassword()), id
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



        // Action du bouton "Gerer les clients"
        btnGerer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre actuelle
                new ViewGererClient().setVisible(true); // Ouvrir la fenêtre de gestion des clients
            }
        });

        // Action du bouton "Retour"
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre actuelle
                new AccueilPage().setVisible(true); // Ouvrir la fenêtre d'accueil
            }
        });

        btnAllComptes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<CompteBancaire> comptes = BanqueController.getAllComptesBancaires();
                new TableComptesView(comptes).setVisible(true);
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
        button.setForeground(Color.WHITE); // Texte du bouton en blanc
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(200, 40)); // Taille uniforme
        return button;
    }
}
