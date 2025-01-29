package Models.blls;

import java.util.ArrayList;

import Models.dals.DAL_CompteCourant;

import Models.entities.CompteCourant;



public class BLL_CompteCourant {
    public static CompteCourant getCompteCourant(int IdClient){return DAL_CompteCourant.getCompteCourant(IdClient);}
    public static CompteCourant getCompteCourantByIdCompte(int IdCompte){return DAL_CompteCourant.getCompteCourantByIdCompte(IdCompte);}
    public static ArrayList<CompteCourant> getAllCompteCourant() {return DAL_CompteCourant.getAllCompteCourant();}
    public static boolean creerCompteCourant(CompteCourant C) {
        if(C!=null) {
            return DAL_CompteCourant.creerCompteCourant(C);
        }
        return false;
    }


    public static boolean supprimerCompteCourant(int IdCompte){
        if(IdCompte!=0)
            return DAL_CompteCourant.supprimerCompteCourant(IdCompte);
        else
            return false;
    }
    public static boolean modifierSolde(double solde,int IdCompte){
        if(solde>=0.0)
            return DAL_CompteCourant.modifierSolde(solde,IdCompte);
        else
            return false;
    }
    public static boolean depotArgent(double montant,int IdCompte){
        if(montant>=0.0)
            return DAL_CompteCourant.depotArgent(montant,IdCompte);
        else
            return false;
    }
    public static boolean retrait(double montant,int IdCompte){
        if(montant>=0.0)
            return DAL_CompteCourant.retrait(montant,IdCompte);
        else
            return false;
    }

}
