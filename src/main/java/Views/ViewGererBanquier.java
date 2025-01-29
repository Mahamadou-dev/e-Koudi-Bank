package Views;
import javax.swing.*;

import Controllers.BanquierController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewGererBanquier extends JFrame {

    public ViewGererBanquier() {
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
        JLabel title = new JLabel("Gestion de Banquiers", SwingConstants.CENTER);
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
        JButton btnAjouter = createButton("Ajouter un Banquier");
        JButton btnSupprimer = createButton("supprimer un Banquier");
        JButton btnModifier = createButton("Modifier Banquier");
        JButton btnRetour = createButton("Retour");

        navbar.add(btnAjouter);
        navbar.add(btnSupprimer);
        navbar.add(btnModifier);
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
                new ViewDirecteur().setVisible(true); // Ouvrir la fenêtre de directeur
            }
        });
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nomField = new JTextField(20);
                JTextField prenomField = new JTextField(20);
                JTextField dateNaisField = new JTextField(20);
                JTextField cinField = new JTextField(20);
                JTextField telField = new JTextField(20);
                JTextField adresseField = new JTextField(20);
                JTextField mailField = new JTextField(20);
                JTextField salaireField = new JTextField(20);
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(10, 2));
                loginPanel.setBackground(new Color(30, 60, 120)); // Couleur personnalisée

                JLabel nomLabel = new JLabel("Nom :");
                nomLabel.setForeground(Color.WHITE);
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

                JLabel salaireLabel = new JLabel("Salaire:");
                salaireLabel.setForeground(Color.WHITE);
                loginPanel.add(salaireLabel);
                loginPanel.add(salaireField);

                JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
                usernameLabel.setForeground(Color.WHITE);
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);

                JLabel passwordLabel = new JLabel("Mot de passe:");
                passwordLabel.setForeground(Color.WHITE);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Ajout d'un Banquier", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        double salaire = Double.parseDouble(salaireField.getText());
                        boolean valid = BanquierController.ajouterBanquier(
                                nomField.getText(),
                                prenomField.getText(),
                                dateNaisField.getText(),
                                cinField.getText(),
                                telField.getText(),
                                adresseField.getText(),
                                mailField.getText(),
                                salaire,
                                usernameField.getText(),
                                new String(passwordField.getPassword())
                        );
                        if (valid) {
                            JOptionPane.showMessageDialog(null, "Nouveau Banquier ajouté(e) !");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erreur : le banquier existe déjà !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "L'salaire doit être un réel valide.");
                    }
                }
            }
        });


        btnSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(1, 2));
                loginPanel.setBackground(new Color(30, 60, 120)); // Couleur personnalisée

                JLabel idLabel = new JLabel("ID:");
                idLabel.setForeground(Color.WHITE);
                loginPanel.add(idLabel);
                loginPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Suppression d'un Banquier", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        boolean valid = BanquierController.supprimerBanquier(id);
                        if (valid) {
                            JOptionPane.showMessageDialog(null, "Banquier supprimé !");
                        } else {
                            JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "L'ID doit être un nombre valide.");
                    }
                }
            }
        });



        // Action du bouton "Modifier salaire"
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField salaireField = new JTextField(20);
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(2, 2));
                loginPanel.setBackground(new Color(30, 60, 120)); // Couleur personnalisée

                JLabel salaireLabel = new JLabel("Nouveau Salaire:");
                salaireLabel.setForeground(Color.WHITE);
                loginPanel.add(salaireLabel);
                loginPanel.add(salaireField);

                JLabel idLabel = new JLabel("ID:");
                idLabel.setForeground(Color.WHITE);
                loginPanel.add(idLabel);
                loginPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Modification du salaire", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        double salaire = Double.parseDouble(salaireField.getText());
                        int id = Integer.parseInt(idField.getText());
                        boolean valid = BanquierController.modifierSalaireBanquier(salaire, id);
                        if (valid) {
                            JOptionPane.showMessageDialog(null, "Salaire modifié !");
                        } else {
                            JOptionPane.showMessageDialog(null, "Données incorrectes !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur: " + ex.getMessage());
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
