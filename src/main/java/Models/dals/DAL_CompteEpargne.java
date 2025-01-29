package Models.dals;



import Models.entities.CompteCourant;
import Models.entities.CompteEpargne;
import Models.entities.CompteEpargne;
import Models.entities.Transaction;
import Models.entities.DataBase;

import java.util.ArrayList;
import java.util.List;

public abstract class DAL_CompteEpargne  {


    public static ArrayList<CompteEpargne> getAllCompteEpargne() {
        return DataBase.compteEpargnes;
    }
    public static boolean creerCompteEpargne(CompteEpargne C) {

        int i = 0;
        for (CompteEpargne c : DataBase.compteEpargnes) {
            if (c.getIdCompte() == C.getIdCompte())
                i++;
        }
        if (i == 0) {
            DataBase.compteEpargnes.add(C);
            return true;
        }

        return false;
    }

    public static CompteEpargne getCompteEpargne(int idClient){
        for(CompteEpargne C : DataBase.compteEpargnes){
            if(C.getIdClient() == idClient){
                System.out.println("C et son idclient "+C.getIdClient());
                return C;
            }
        }
        System.out.println("Ici DalCompteEpargne Tous les comptes sont vides ");
        return null;
    }
    public static CompteEpargne getCompteEpargneByIdCompte(int idCompte){
        for(CompteEpargne C : DataBase.compteEpargnes){
            if(C.getIdCompte() == idCompte){
                System.out.println("C et son idclient "+C.getIdClient());
                return C;
            }
        }

        return null;
    }
    public static boolean supprimerCompteEpargne(int idCompte){
        for(CompteEpargne E : DataBase.compteEpargnes){
            if(E.getIdCompte() == idCompte){
                DataBase.compteEpargnes.remove(E);
                return true;
            }
        }
        return false;
    }
    public static boolean modifierSolde(double solde,int IdCompte){
        for(CompteEpargne C : DataBase.compteEpargnes){
            if(C.getIdCompte() == IdCompte){
                C.setSolde(solde);
                return  true;
            }
        }
        return false;
    }
    public static boolean depotArgent(double montant,int IdCompte){
        for(CompteEpargne C : DataBase.compteEpargnes){
            if(C.getIdCompte() == IdCompte){
                double S=C.getSolde()+montant;
                C.setSolde(S);
                return true;
            }
        }
        return false;
    }
    public static boolean retrait(double montant,int IdCompte){
        for(CompteEpargne C : DataBase.compteEpargnes){
            if(C.getIdCompte() == IdCompte){
                if(montant<=C.getSolde()){
                    double S=C.getSolde()-montant;
                    C.setSolde(S);
                    return true;
                }else
                    return false;
            }
        }
        return false;
    }

}
