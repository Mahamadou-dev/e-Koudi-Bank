package Controllers;

import Models.blls.BLL_Transaction;

import Models.entities.DataBase;
import Models.entities.Transaction;

import java.util.ArrayList;
import java.util.Iterator;

public class TransactionController {
    public static ArrayList<Transaction> getAllTransaction() {
        return BLL_Transaction.getAllTransaction();
    }

    public static ArrayList<Transaction> getTransactionByIdCompte(int idCompte) {
        return BLL_Transaction.getTransactionByIdCompte(idCompte);
    }
    public static boolean ajouterTransaction(Transaction T){
        try {
            System.out.println("ici transacControll, la transac qui va etre ajoute a la liste::::"+T.toString());
            DataBase.transactions.add(T);
            return true;
        } catch (Exception e) {
            System.out.println("Erreur d'ajout de transaction"+e.getMessage());
            return false;
        }


    }
    public static boolean supprimerTransactions(int idClient) {
        try {
            Iterator<Transaction> iterator = DataBase.transactions.iterator();
            while (iterator.hasNext()) {
                Transaction T = iterator.next();
                if (BanqueController.getCompteBancaireByIdCompte(T.getIdCompte()).getIdClient() == idClient) {
                    iterator.remove();
                    System.out.println("Transaction Supprimée");
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression des transactions: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}