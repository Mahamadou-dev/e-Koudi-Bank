package Views;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Models.entities.CompteBancaire;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TableComptesView extends JFrame {

    public TableComptesView(List<CompteBancaire> comptes) {
        setTitle("Liste des Comptes Bancaires");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Colonnes du tableau
        String[] colonnes = {"IDClient", "IDCompte", "Solde", "Date de création", "Type de compte"};

        // Données du tableau
        DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        for (CompteBancaire b : comptes) {
            model.addRow(new Object[]{b.getIdClient(), b.getIdCompte(), b.getSolde(), b.getDatecreation(), b.getType()});
        }

        // Création du tableau
        JTable table = new JTable(model);

        // Mise en forme du tableau (fond et texte)
        table.setBackground(new Color(30, 60, 120)); // Fond de la table
        table.setForeground(Color.WHITE); // Texte des cellules en blanc

        // Modification du header pour avoir un texte blanc
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setForeground(Color.WHITE); // Texte des en-têtes en blanc
        tableHeader.setBackground(new Color(30, 60, 120)); // Fond de l'en-tête

        // Personnaliser la police pour les cellules
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Police standard

        // Personnaliser la police pour l'en-tête
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14)); // Police en gras pour l'en-tête

        // Ajouter un JScrollPane pour faire défiler le tableau
        JScrollPane scrollPane = new JScrollPane(table);

        // Ajouter le tableau à la fenêtre
        add(scrollPane, BorderLayout.CENTER);
    }
}
