package Models.dals;


import Models.entities.CompteCourant;
import Models.entities.CompteCourant;
import Models.entities.DataBase;

import java.util.ArrayList;


public abstract class DAL_CompteCourant{

    public static ArrayList<CompteCourant> getAllCompteCourant() {
        return DataBase.compteCourants;
    }



    public static boolean creerCompteCourant(CompteCourant C) {

        int i = 0;
        for (CompteCourant c : DataBase.compteCourants) {
            if (c.getIdCompte() == C.getIdCompte())
                i++;
        }
        if (i == 0) {
            DataBase.compteCourants.add(C);
            return true;
        }

        return false;
    }
    public static CompteCourant getCompteCourant(int idClient){
        for(CompteCourant C : DataBase.compteCourants){
            if(C.getIdClient() == idClient){
                System.out.println("C et son idclient "+C.getIdClient());
                return C;
            }
        }
        System.out.println("Ici DalCompteCourant Tous les comptes sont vides ");
        return null;
    }
    public static CompteCourant getCompteCourantByIdCompte(int idCompte){
        for(CompteCourant C : DataBase.compteCourants){
            if(C.getIdCompte() == idCompte){
                System.out.println("C et son idclient "+C.getIdClient());
                return C;
            }
        }

        return null;
    }

    public static boolean supprimerCompteCourant(int IdCompte){
        for(CompteCourant C : DataBase.compteCourants){
            if(C.getIdCompte() == IdCompte){
                DataBase.compteCourants.remove(C);
                return  true;
            }
        }
        return false;
    }
    public static boolean modifierSolde(double solde,int IdCompte){
        for(CompteCourant C : DataBase.compteCourants){
            if(C.getIdCompte() == IdCompte){
                C.setSolde(solde);
                return  true;
            }
        }
        return false;
    }
    public static boolean depotArgent(double montant,int IdCompte){
        for(CompteCourant C : DataBase.compteCourants){
            if(C.getIdCompte() == IdCompte){
                double S=C.getSolde()+montant;
                C.setSolde(S);
                return true;
            }
        }
        return false;
    }
    public static boolean retrait(double montant, int IdCompte) {
        for (CompteCourant C : DataBase.compteCourants) {
            if (C.getIdCompte() == IdCompte) { // Vérifier si l'ID correspond
                if (montant <= C.getSolde()) { // Vérifier que le solde est suffisant
                    double nouveauSolde = C.getSolde() - montant;
                    C.setSolde(nouveauSolde); // Débiter le montant
                    return true; // Retrait réussi
                } else {
                    return false; // Solde insuffisant
                }
            }
        }
        return false; // Compte non trouvé
    }


}
