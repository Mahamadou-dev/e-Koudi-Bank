package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Models.entities.Transaction;

public class TableTransactionView extends JFrame {

    public TableTransactionView(List<Transaction> transactions) {
        setTitle("Liste des Transactions");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Colonnes du tableau
        String[] colonnes = {"ID", "Type", "Montant", "Date"};

        // Données du tableau
        DefaultTableModel model = new DefaultTableModel(colonnes, 0);
        if (transactions != null) {
            for (Transaction T : transactions) {
                model.addRow(new Object[]{T.getIdTransaction(), T.getType(), T.getMontant(), T.getDate()});
            }
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
