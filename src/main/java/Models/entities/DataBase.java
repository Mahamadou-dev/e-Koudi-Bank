package Models.entities;

import java.util.ArrayList;

import java.util.ArrayList;

public class DataBase {

    // Collections pour stocker les données
    public static  ArrayList<Client> clients = new ArrayList<>();
    public static  ArrayList<Banquier> banquiers = new ArrayList<>();
    public static  ArrayList<Transaction> transactions = new ArrayList<>();
    public static  ArrayList<CompteEpargne> compteEpargnes = new ArrayList<>();
    public static  ArrayList<CompteCourant> compteCourants = new ArrayList<>();
    public static  Directeur directeur=new Directeur("Moussa", "Idi", "1960-06-02", "NE1000001",
            "20000121", "Monastir Omrane", "mousdi@gmail.com", 2500.00, "pwd", "D");
    public static boolean verifierClient(int idClient){
        boolean result=false;
        for(Client C: clients){
            if (C.getId() == idClient) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean verifierBanquier(int idBanquier){
        boolean result=false;
        for(Banquier B: banquiers){
            if (B.getId() == idBanquier) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean verifierTransaction(int idTransaction){
        boolean result=false;
        for(Transaction T: transactions){
            if (T.getIdTransaction() == idTransaction) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean verifierCompte(int idCompte){
        boolean result=false;
        for(CompteCourant Cc: compteCourants){
            if (Cc.getIdCompte() == idCompte) {
                result = true;
                break;
            }
        }
        for(CompteEpargne Ce: compteEpargnes){
            if (Ce.getIdCompte() == idCompte) {
                result = true;
                break;
            }
        }
        return result;
    }

    // Initialisation des données de base
    /*public static void initializeData() {
        // Ajouter des clients
        clients.add(new Client("Client1", "Client1", "2000-10-20", "NE210030",
                "+216 30 231 123", "Monastir Omrane", "client1@gmail.com", "C1", "C1"));
        clients.add(new Client("Client2", "Client2", "2000-10-20", "NE210031",
                "+216 30 456 123", "Monastir Omrane", "client2@gmail.com", "C2", "C2"));

        // Ajouter un directeur
        Directeur directeur = new Directeur("Moussa", "Idi", "1960-06-02", "NE1000001",
                "20000121", "Monastir Omrane", "mousdi@gmail.com", 2500.00, "pwd", "D");

        // Ajouter des banquiers
        banquiers.add(new Banquier("Banquier1", "Banquier1", "1985-03-15", "NE210040",
                "+216 30 789 123", "Tunis Centre", "banquier1@gmail.com", 25000.4, "B1", "B1"));
        banquiers.add(new Banquier("Banquier2", "Banquier2", "1990-07-22", "NE210041",
                "+216 30 987 123", "Tunis Centre", "banquier2@gmail.com", 2500.3, "B2", "B2"));

        // Ajouter des comptes
        compteCourants.add(new CompteCourant(1, "2024-11-21", TypeCompte.COURANT));
        compteEpargnes.add(new CompteEpargne(2, 2, TypeCompte.EPARGNE, "2024-12-01"));
    }*/
}