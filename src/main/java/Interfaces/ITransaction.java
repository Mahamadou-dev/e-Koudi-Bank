package Interfaces;
import Models.entities.Transaction;
import java.util.ArrayList;

public interface ITransaction {

   Transaction getTransaction(long operationID);

   ArrayList<Transaction> getAllTransaction();

   ArrayList<Transaction> getTransactionByClient(long clientID);

   ArrayList<Transaction> getTransactionByAgent(long banquierID);

   void ajouterTransaction(Transaction transaction);

   boolean supprimerTransaction(Transaction transaction);

   boolean updateTransaction(long IDTransaction,Transaction tansaction);


}
