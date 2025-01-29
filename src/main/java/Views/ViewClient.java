package Views;
import javax.swing.*;
import Controllers.*;
import Models.entities.CompteCourant;
import Models.entities.CompteEpargne;
import Models.entities.Transaction;
import utils.Session;
import Controllers.ClientController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ViewClient  extends JFrame {
    public ViewClient() {
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
        JLabel title = new JLabel("Espace Client", SwingConstants.CENTER);
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
        JButton btnEspaceCompte = createButton("Mon Compte");
        JButton btnAllTransactions = createButton("Toutes mes transactions ");
        JButton btnPreter = createButton("Preter");
        JButton btnModifier = createButton("Modifier mes infos");
        JButton btnRembourser= createButton("Rembourser");
        JButton btnRetour = createButton("Retour");

        navbar.add(btnEspaceCompte);
        navbar.add(btnAllTransactions);
        navbar.add(btnPreter);
        navbar.add(btnRembourser);
        navbar.add(btnModifier);
        navbar.add(btnRetour);

        background.add(navbar);

        // Ligne de séparation sous les boutons
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(100, 170, 1300, 3); // Ligne fine blanche
        background.add(separator);

        // Action du bouton "Mon Compte"
        btnEspaceCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre actuelle
                new ViewCompte().setVisible(true); // Ouvrir la fenêtre de comptes
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

        // Action du bouton "Toutes mes transactions"
        btnAllTransactions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idc = Session.getUserId();
                System.out.println("ici viewclient le Client de la session====" + idc);
                CompteCourant Cc = CompteCourantController.getCompteCourant(idc); // Pour savoir le type de compte du client
                CompteEpargne Ce = CompteEpargneController.getCompteEpargne(idc); // Idem
                List<Transaction> transactions;
                if (Cc == null && Ce != null) {
                    System.out.println("ici viewclient le id de compte de Client de la session====" + Ce.getIdCompte());
                    transactions = TransactionController.getTransactionByIdCompte(Ce.getIdCompte());
                    System.out.println("ici view client la taille de la liste de transcc====" + transactions.size());
                } else if (Cc != null && Ce == null) {
                    System.out.println("ici view client le id de compte de Client de la session====" + Cc.getIdCompte());
                    transactions = TransactionController.getTransactionByIdCompte(Cc.getIdCompte());
                    System.out.println("ici view client la taille de la liste de transcc====" + transactions.size());
                } else {
                    System.out.println("ici view client le compte est vide_____");
                    transactions = new ArrayList<>();
                }
                new TableTransactionView(transactions).setVisible(true);
            }
        });

        // Action du bouton "Prêter"
        btnPreter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField salaireField = new JTextField(20);
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(2, 2));
                loginPanel.add(new JLabel("Montant:"));
                loginPanel.add(salaireField);
                loginPanel.add(new JLabel("Votre ID:"));
                loginPanel.add(idField);

                // Modifier la couleur du texte des labels en blanc
                for (Component comp : loginPanel.getComponents()) {
                    if (comp instanceof JLabel) {
                        ((JLabel) comp).setForeground(Color.WHITE);
                    }
                }

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Prêt d'argent", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        double salaire = Double.parseDouble(salaireField.getText());
                        int id = Integer.parseInt(idField.getText());
                        boolean valid = ClientController.preter(salaire, id);
                        if (valid) {
                            JOptionPane.showMessageDialog(null, "Vous avez prêté " + salaire + " DT !!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Données incorrectes !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur: " + ex.getMessage());
                    }
                }
            }
        });

        // Action du bouton "Rembourser"
        btnRembourser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField salaireField = new JTextField(20);
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(2, 2));
                loginPanel.add(new JLabel("Montant:"));
                loginPanel.add(salaireField);
                loginPanel.add(new JLabel("Votre ID:"));
                loginPanel.add(idField);

                // Modifier la couleur du texte des labels en blanc
                for (Component comp : loginPanel.getComponents()) {
                    if (comp instanceof JLabel) {
                        ((JLabel) comp).setForeground(Color.WHITE);
                    }
                }

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Remboursement de prêt", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        double salaire = Double.parseDouble(salaireField.getText());
                        int id = Integer.parseInt(idField.getText());
                        boolean valid = ClientController.rembourser(salaire, id);
                        if (valid) {
                            JOptionPane.showMessageDialog(null, "Vous avez remboursé " + salaire + " DT !!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Données incorrectes !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur: " + ex.getMessage());
                    }
                }
            }
        });

        // Action du bouton "Modifier mes infos"
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de Modification pour le Client
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

                // Configuration du panneau avec un fond bleu foncé
                loginPanel.setLayout(new GridLayout(24, 2));
                loginPanel.setBackground(new Color(30, 60, 120)); // Fond bleu foncé

                // Ajout de la couleur blanche pour le texte dans chaque JLabel
                JLabel anciennesInfosLabel = new JLabel("Anciennes infos");
                anciennesInfosLabel.setForeground(Color.WHITE);
                loginPanel.add(anciennesInfosLabel);
                loginPanel.add(new JLabel(""));

                // Anciennes informations avec texte blanc
                JLabel nomLabel = new JLabel("Nom :");
                nomLabel.setForeground(Color.WHITE);
                loginPanel.add(nomLabel);
                JLabel nomValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getNom());
                nomValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(nomValueLabel);

                JLabel prenomLabel = new JLabel("Prenom :");
                prenomLabel.setForeground(Color.WHITE);
                loginPanel.add(prenomLabel);
                JLabel prenomValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getPrenom());
                prenomValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(prenomValueLabel);

                JLabel dateNaisLabel = new JLabel("Date de Naissance :");
                dateNaisLabel.setForeground(Color.WHITE);
                loginPanel.add(dateNaisLabel);
                JLabel dateNaisValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getDateNais());
                dateNaisValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(dateNaisValueLabel);

                JLabel cinLabel = new JLabel("CIN :");
                cinLabel.setForeground(Color.WHITE);
                loginPanel.add(cinLabel);
                JLabel cinValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getCIN());
                cinValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(cinValueLabel);

                JLabel telLabel = new JLabel("TEL :");
                telLabel.setForeground(Color.WHITE);
                loginPanel.add(telLabel);
                JLabel telValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getTel());
                telValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(telValueLabel);

                JLabel adresseLabel = new JLabel("Adresse :");
                adresseLabel.setForeground(Color.WHITE);
                loginPanel.add(adresseLabel);
                JLabel adresseValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getAdresse());
                adresseValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(adresseValueLabel);

                JLabel mailLabel = new JLabel("Mail :");
                mailLabel.setForeground(Color.WHITE);
                loginPanel.add(mailLabel);
                JLabel mailValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getMail());
                mailValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(mailValueLabel);

                JLabel usernameLabel = new JLabel("Nom d'utilisateur :");
                usernameLabel.setForeground(Color.WHITE);
                loginPanel.add(usernameLabel);
                JLabel usernameValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getUsername());
                usernameValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(usernameValueLabel);

                JLabel passwordLabel = new JLabel("Mot de passe :");
                passwordLabel.setForeground(Color.WHITE);
                loginPanel.add(passwordLabel);
                JLabel passwordValueLabel = new JLabel(ClientController.getClient(Session.getUserId()).getPassword());
                passwordValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(passwordValueLabel);

                JLabel soldeLabel = new JLabel("Votre solde du compte:");
                soldeLabel.setForeground(Color.WHITE);
                loginPanel.add(soldeLabel);
                JLabel soldeValueLabel = new JLabel("" + BanqueController.getCompteBancaire(Session.getUserId()).getSolde());
                soldeValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(soldeValueLabel);

                JLabel soldePretLabel = new JLabel("Votre solde de pret");
                soldePretLabel.setForeground(Color.WHITE);
                loginPanel.add(soldePretLabel);
                JLabel soldePretValueLabel = new JLabel("" + ClientController.getClient(Session.getUserId()).getSoldePret());
                soldePretValueLabel.setForeground(Color.WHITE); // Valeur en blanc
                loginPanel.add(soldePretValueLabel);

                loginPanel.add(new JLabel(""));
                loginPanel.add(new JLabel(""));
                loginPanel.add(new JLabel(""));
                loginPanel.add(new JLabel(""));

                // Nouvelle section d'informations avec texte blanc
                JLabel nouvellesInfosLabel = new JLabel("Nouvelles infos");
                nouvellesInfosLabel.setForeground(Color.WHITE);
                loginPanel.add(nouvellesInfosLabel);
                loginPanel.add(new JLabel(""));

                // Ajout des champs pour les nouvelles informations
                JLabel nomFieldLabel = new JLabel("Nom :");
                nomFieldLabel.setForeground(Color.WHITE);
                nomField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                nomField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(nomFieldLabel);
                loginPanel.add(nomField);

                JLabel prenomFieldLabel = new JLabel("Prenom:");
                prenomFieldLabel.setForeground(Color.WHITE);
                prenomField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                prenomField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(prenomFieldLabel);
                loginPanel.add(prenomField);

                JLabel dateNaisFieldLabel = new JLabel("Date de naissance:");
                dateNaisFieldLabel.setForeground(Color.WHITE);
                dateNaisField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                dateNaisField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(dateNaisFieldLabel);
                loginPanel.add(dateNaisField);

                JLabel cinFieldLabel = new JLabel("CIN:");
                cinFieldLabel.setForeground(Color.WHITE);
                cinField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                cinField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(cinFieldLabel);
                loginPanel.add(cinField);

                JLabel telFieldLabel = new JLabel("TEL:");
                telFieldLabel.setForeground(Color.WHITE);
                telField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                telField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(telFieldLabel);
                loginPanel.add(telField);

                JLabel adresseFieldLabel = new JLabel("Adresse:");
                adresseFieldLabel.setForeground(Color.WHITE);
                adresseField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                adresseField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(adresseFieldLabel);
                loginPanel.add(adresseField);

                JLabel mailFieldLabel = new JLabel("Mail:");
                mailFieldLabel.setForeground(Color.WHITE);
                mailField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                mailField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(mailFieldLabel);
                loginPanel.add(mailField);

                JLabel usernameFieldLabel = new JLabel("Nom d'utilisateur:");
                usernameFieldLabel.setForeground(Color.WHITE);
                usernameField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                usernameField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(usernameFieldLabel);
                loginPanel.add(usernameField);

                JLabel passwordFieldLabel = new JLabel("Mot de passe:");
                passwordFieldLabel.setForeground(Color.WHITE);
                passwordField.setBackground(new Color(30, 60, 120)); // Fond sombre pour le champ
                passwordField.setForeground(Color.WHITE); // Texte en blanc
                loginPanel.add(passwordFieldLabel);
                loginPanel.add(passwordField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Modifier mes infos", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        boolean valid = ClientController.modifierClient(
                                nomField.getText(),
                                prenomField.getText(),
                                dateNaisField.getText(),
                                cinField.getText(),
                                telField.getText(),
                                adresseField.getText(),
                                mailField.getText(),
                                usernameField.getText(),
                                new String(passwordField.getPassword()),
                                Session.getUserId()
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






    }

    // Méthode pour créer un bouton personnalisé
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE); // Texte en blanc
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(180, 40));
        return button;
    }
}
