package Views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Controllers.BanqueController;
import Controllers.CompteCourantController;
import Controllers.CompteEpargneController;
import Controllers.TransactionController;
import Models.entities.CompteBancaire;
import Models.entities.CompteCourant;
import Models.entities.Transaction;
import utils.Session;

public class ViewCompte extends JFrame {

    public ViewCompte() {
        // Configuration de la fenêtre
        setTitle("E-KOUDI BANK");
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Position absolue pour un contrôle total des éléments

        // Ajout d'une image de fond
        JLabel background = new JLabel(new ImageIcon("/Ressource/BANK2.jpg")); // Assurez-vous que BANK2.jpg est dans le même dossier
        background.setBounds(0, 0, 1500, 1000);
        add(background); // Changement de "ajouter" en "add"

        // Création du header
        JLabel title = new JLabel("Espace Compte", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE); // Texte en blanc
        title.setBounds(0, 20, 1500, 50);
        background.add(title);

        // Barre de navigation
        JPanel navbar = new JPanel();
        navbar.setOpaque(false); // Rendre transparent pour afficher l'image de fond
        navbar.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        navbar.setBounds(0, 100, 1500, 70); // Positionnement

        // Boutons de navigation
        JButton btnRetrait = createButton("Retrait");
        JButton btnTransferer = createButton("Transfèrer");
        JButton btnRetour = createButton("Retour");
        navbar.add(btnRetrait);
        navbar.add(btnTransferer);
        navbar.add(btnRetour);

        background.add(navbar);

        // Ligne de séparation sous les boutons
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(100, 170, 1300, 3); // Ligne fine blanche
        background.add(separator);

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retour à l'accueil
                dispose(); // Fermer la fenêtre actuelle
                new ViewClient().setVisible(true);
            }
        });

        btnRetrait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField salaireField = new JTextField(20);
                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(2, 2));

                JLabel montantLabel = new JLabel("Montant:");
                montantLabel.setForeground(Color.WHITE);  // Texte en blanc
                loginPanel.add(montantLabel);
                loginPanel.add(salaireField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Retrait d'argent", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        // Validation du montant
                        if (salaireField.getText().isEmpty()) {
                            throw new NumberFormatException("Le montant est vide.");
                        }
                        double salaire = Double.parseDouble(salaireField.getText());
                        if (salaire <= 0) {
                            throw new NumberFormatException("Le montant doit être supérieur à 0.");
                        }
                        // Récupération des informations du compte utilisateur
                        int id = Session.getUserId();
                        System.out.println("ici view compte, id de client de la session=" + id);
                        CompteBancaire C = BanqueController.getCompteBancaire(id);
                        int idc = C.getIdCompte();
                        System.out.println("ici view compte, Id du compte de client de la session =" + idc);


                        // Vérification du type de compte et tentative de retrait
                        boolean valid;
                        if (C instanceof CompteCourant) {
                            valid = CompteCourantController.retrait(salaire, idc);
                        } else {
                            valid = CompteEpargneController.retrait(salaire, idc);
                        }
                        System.out.println("valid:" + valid);
                        if (valid) {
                            // Message de succès
                            JOptionPane.showMessageDialog(null, "Vous avez retiré " + salaire + " DT de votre compte !");

                            // Saisie d'informations supplémentaires pour la transaction
                            JTextField typeField = new JTextField(20);
                            JTextField dateField = new JTextField(20);
                            JPanel transactionPanel = new JPanel();
                            transactionPanel.setLayout(new GridLayout(2, 2));

                            JLabel typeLabel = new JLabel("Type de transaction:");
                            typeLabel.setForeground(Color.WHITE);  // Texte en blanc
                            JLabel dateLabel = new JLabel("Date de transaction (aaaa-MM-jj):");
                            dateLabel.setForeground(Color.WHITE);  // Texte en blanc
                            transactionPanel.add(typeLabel);
                            transactionPanel.add(typeField);
                            transactionPanel.add(dateLabel);
                            transactionPanel.add(dateField);

                            int option1 = JOptionPane.showConfirmDialog(null, transactionPanel, "Informations sur la transaction", JOptionPane.OK_CANCEL_OPTION);
                            if (option1 == JOptionPane.OK_OPTION) {
                                // Validation des informations de la transaction
                                String type = typeField.getText();
                                String date = dateField.getText();
                                if (type.isEmpty() || date.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis!");
                                    return;
                                }
                                // Validation du format de la date
                                try {
                                    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                } catch (DateTimeParseException ex) {
                                    JOptionPane.showMessageDialog(null, "Format de date incorrect (attendu: aaaa-MM-jj)!");
                                    return;
                                }
                                // Ajout de la transaction
                                Transaction T = new Transaction(type, salaire, date, C.getIdCompte());
                                boolean valid1 = TransactionController.ajouterTransaction(T);
                                if (valid1) {
                                    JOptionPane.showMessageDialog(null, "Transaction validée.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Échec de l'ajout de la transaction. Données incorrectes.");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Échec du retrait. Solde insuffisant ou erreur.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur: " + ex.getMessage());
                    }
                }
            }
        });

        btnTransferer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField montantField = new JTextField(20);
                JTextField idDestinataireField = new JTextField(20);
                JPanel transferPanel = new JPanel();
                transferPanel.setLayout(new GridLayout(2, 2));

                JLabel montantLabel = new JLabel("Montant:");
                montantLabel.setForeground(Color.WHITE);  // Texte en blanc
                transferPanel.add(montantLabel);
                transferPanel.add(montantField);

                JLabel idDestinataireLabel = new JLabel("ID du client destinataire:");
                idDestinataireLabel.setForeground(Color.WHITE);  // Texte en blanc
                transferPanel.add(idDestinataireLabel);
                transferPanel.add(idDestinataireField);

                int option = JOptionPane.showConfirmDialog(null, transferPanel, "Transfert d'argent", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        // Validation des champs
                        if (montantField.getText().isEmpty() || idDestinataireField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis!");
                            return;
                        }

                        // Conversion des champs
                        double montant = Double.parseDouble(montantField.getText());
                        if (montant <= 0) {
                            throw new NumberFormatException("Le montant doit être supérieur à 0.");
                        }
                        int idDestinataire = Integer.parseInt(idDestinataireField.getText());

                        // Récupération de l'ID utilisateur actuel (source du transfert)
                        int idSource = Session.getUserId();
                        CompteBancaire source = BanqueController.getCompteBancaire(idSource);
                        CompteBancaire destinataire = BanqueController.getCompteBancaire(idDestinataire);
                        boolean valid;

                        // Appel au contrôleur pour effectuer le transfert
                        valid = BanqueController.transfert(montant, source, destinataire);
                        if (valid) {
                            // Succès du transfert
                            JOptionPane.showMessageDialog(null, "Vous avez transféré " + montant + " DT au client avec ID " + idDestinataire + " !");

                            // Saisie d'informations supplémentaires pour la transaction
                            JTextField typeField = new JTextField(20);
                            JTextField dateField = new JTextField(20);
                            JPanel transactionPanel = new JPanel();
                            transactionPanel.setLayout(new GridLayout(2, 2));
                            transactionPanel.add(new JLabel("Type de transaction:"));
                            transactionPanel.add(typeField);
                            transactionPanel.add(new JLabel("Date de transaction (aaaa-MM-jj):"));
                            transactionPanel.add(dateField);

                            // Changer la couleur du texte en blanc
                            ((JLabel) transactionPanel.getComponent(0)).setForeground(Color.WHITE);
                            ((JLabel) transactionPanel.getComponent(2)).setForeground(Color.WHITE);

                            int option1 = JOptionPane.showConfirmDialog(null, transactionPanel, "Informations sur la transaction", JOptionPane.OK_CANCEL_OPTION);
                            if (option1 == JOptionPane.OK_OPTION) {
                                // Validation des informations de la transaction
                                String type = typeField.getText();
                                String date = dateField.getText();
                                if (type.isEmpty() || date.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis!");
                                    return;
                                }

                                // Validation du format de la date
                                try {
                                    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                } catch (DateTimeParseException ex) {
                                    JOptionPane.showMessageDialog(null, "Format de date incorrect (attendu: aaaa-MM-jj)!");
                                    return;
                                }

                                // Ajout de la transaction
                                Transaction T = new Transaction(type, montant, date, source.getIdCompte());
                                boolean valid1 = TransactionController.ajouterTransaction(T);
                                if (valid1) {
                                    JOptionPane.showMessageDialog(null, "Transaction validée.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Échec de l'ajout de la transaction. Données incorrectes.");
                                }
                            }
                        } else {
                            // Échec du transfert
                            JOptionPane.showMessageDialog(null, "Le transfert a échoué. Vérifiez les informations saisies.");
                        }
                    } catch (NumberFormatException ex) {
                        // Gestion des erreurs de format
                        JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                    }
                }
            }
        });
    }

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
