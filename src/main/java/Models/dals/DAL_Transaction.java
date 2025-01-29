package Models.dals;

import Models.entities.CompteBancaire;
import Models.entities.DataBase;
import Models.entities.Transaction;

import java.util.ArrayList;

public class DAL_Transaction{
     public static ArrayList<Transaction> getAllTransaction(){
         return DataBase.transactions;
     }
     public static ArrayList<Transaction> getTransactionByIdCompte(int idCompte){
         ArrayList<Transaction> T=new ArrayList<>();
         for(Transaction Tmp:DataBase.transactions){
             if(Tmp.getIdCompte()==idCompte){
                 T.add(Tmp);
             }

         }
         return T;
     }

}