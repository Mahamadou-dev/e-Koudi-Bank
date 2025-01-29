package Models.blls;

import Models.dals.DAL_Transaction;
import Models.entities.CompteBancaire;
import Models.entities.DataBase;
import Models.entities.Transaction;

import java.util.ArrayList;

public class BLL_Transaction {
    public static ArrayList<Transaction> getAllTransaction(){
        return DAL_Transaction.getAllTransaction();
    }
    public static ArrayList<Transaction> getTransactionByIdCompte(int idCompte){
        return DAL_Transaction.getTransactionByIdCompte(idCompte);
    }
}
