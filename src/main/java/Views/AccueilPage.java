package Views;

import javax.swing.*;
import Controllers.BanquierController;
import Controllers.DirecteurController;
import utils.Session;
import Controllers.ClientController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class AccueilPage extends JFrame {

    public AccueilPage() {
        // Configuration de la fenêtre
        setTitle("E-KOUDI BANK");
        setForeground(Color.BLACK);
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Position absolue pour un contrôle total des éléments

        // Ajout d'une image de fond
        System.out.println(new File("../Ressource/BANK2.jpg").getAbsolutePath());
        URL imageUrl = getClass().getResource("/Resource/BANK2.jpg");
        JLabel background = null;
        if (imageUrl == null) {
            System.out.println("Image non trouvée !");
        } else {
            background = new JLabel(new ImageIcon(imageUrl));
            background.setBounds(0, 0, 1500, 1000);
            add(background);
        }

        // Configuration des couleurs des boîtes de dialogue
        UIManager.put("OptionPane.background", new Color(30, 60, 120));  // Fond bleu foncé comme les boutons
        UIManager.put("Panel.background", new Color(30, 60, 120));  // Fond du panneau de la boîte de dialogue
        UIManager.put("OptionPane.messageForeground", Color.WHITE);  // Texte blanc

        // Création du header
        JLabel title = new JLabel("BIENVENUE", SwingConstants.CENTER);
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
        JButton btnDirecteur = createButton("Espace Directeur");
        JButton btnClient = createButton("Espace Client");
        JButton btnBanquier = createButton("Espace Banquier");
        JButton btnQuitter = createButton("Quitter");

        navbar.add(btnDirecteur);
        navbar.add(btnClient);
        navbar.add(btnBanquier);
        navbar.add(btnQuitter);
        background.add(navbar);

        // Ligne de séparation sous les boutons
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(100, 170, 1300, 2); // Ligne fine blanche
        background.add(separator);

        // Action du bouton "Quitter"
        btnQuitter.addActionListener(e -> System.exit(0));

        // Action du bouton "Espace Directeur"
        btnDirecteur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de login pour le Directeur
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(3, 2));
                // Définit la couleur du texte en blanc pour les labels
                JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
                usernameLabel.setForeground(Color.WHITE);
                JLabel passwordLabel = new JLabel("Mot de passe:");
                passwordLabel.setForeground(Color.WHITE);
                JLabel idLabel = new JLabel("ID:");
                idLabel.setForeground(Color.WHITE);
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);
                loginPanel.add(idLabel);
                loginPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Login Directeur", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText()); // Conversion de l'ID en entier
                        String username = usernameField.getText();
                        String password = new String(passwordField.getPassword());

                        // Appel à la méthode d'authentification dans le contrôleur
                        boolean valid = DirecteurController.loginDirecteur(username, password, id);

                        if (valid) {
                            Session.setUserId(id);
                            JOptionPane.showMessageDialog(null, "Connexion réussie !");
                            dispose(); // Fermer la fenêtre de login
                            new ViewDirecteur().setVisible(true); // Ouvrir la fenêtre du Directeur
                        } else {
                            JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "L'ID doit être un nombre valide.");
                    }
                }
            }
        });

        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de login pour le Client
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(3, 2));
                // Définit la couleur du texte en blanc pour les labels
                JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
                usernameLabel.setForeground(Color.WHITE);
                JLabel passwordLabel = new JLabel("Mot de passe:");
                passwordLabel.setForeground(Color.WHITE);
                JLabel idLabel = new JLabel("ID:");
                idLabel.setForeground(Color.WHITE);
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);
                loginPanel.add(idLabel);
                loginPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Login Client", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        boolean valid = ClientController.loginClient(
                                usernameField.getText(),
                                new String(passwordField.getPassword()),
                                id);
                        if (valid) {
                            Session.setUserId(id);
                            JOptionPane.showMessageDialog(null, "Connexion réussie !");
                            dispose(); // Fermer la fenêtre actuelle
                            new ViewClient().setVisible(true); // Ouvrir la fenêtre Client
                        } else {
                            JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "L'ID doit être un nombre valide.");
                    }
                }
            }
        });

        btnBanquier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fenêtre de login pour le Banquier
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JTextField idField = new JTextField(20);

                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(3, 2));
                // Définit la couleur du texte en blanc pour les labels
                JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
                usernameLabel.setForeground(Color.WHITE);
                JLabel passwordLabel = new JLabel("Mot de passe:");
                passwordLabel.setForeground(Color.WHITE);
                JLabel idLabel = new JLabel("ID:");
                idLabel.setForeground(Color.WHITE);
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);
                loginPanel.add(idLabel);
                loginPanel.add(idField);

                int option = JOptionPane.showConfirmDialog(null, loginPanel, "Login Banquier", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        boolean valid = BanquierController.loginBanquier(
                                usernameField.getText(),
                                new String(passwordField.getPassword()),
                                id
                        );
                        if (valid) {
                            Session.setUserId(id);
                            JOptionPane.showMessageDialog(null, "Connexion réussie !");
                            dispose(); // Fermer la fenêtre actuelle
                            new ViewBanquier().setVisible(true); // Ouvrir la fenêtre Banquier
                        } else {
                            JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "L'ID doit être un nombre valide.");
                    }
                }
            }
        });
    }

    /**
     * Méthode utilitaire pour créer un bouton stylisé
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(30, 60, 120)); // Bleu foncé pour l'effet de pression
                } else if (getModel().isRollover()) {
                    g.setColor(new Color(70, 120, 180)); // Bleu plus clair pour l'effet de survol
                } else {
                    g.setColor(new Color(30, 60, 120)); // Bleu foncé pour l'état normal
                }

                // Dessiner les coins arrondis
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Coins arrondis
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 40)); // Taille uniforme
        button.setContentAreaFilled(false);  // Empêcher le remplissage de la zone de contenu
        button.setBorder(BorderFactory.createEmptyBorder()); // Supprimer la bordure par défaut
        return button;
    }
}
