package Models.blls;

import java.util.ArrayList;


import Models.dals.DAL_CompteEpargne;
import Models.dals.DAL_CompteEpargne;
import Models.entities.CompteEpargne;
import Models.entities.CompteEpargne;



public class BLL_CompteEpargne {
    public static CompteEpargne getCompteEpargne(int IdClient){return DAL_CompteEpargne.getCompteEpargne(IdClient);}
    public static CompteEpargne getCompteEpargneByIdCompte(int IdCompte){return DAL_CompteEpargne.getCompteEpargneByIdCompte(IdCompte);}
    public static ArrayList<CompteEpargne> getAllCompteEpargne() {return DAL_CompteEpargne.getAllCompteEpargne();}
    public static boolean creerCompteEpargne(CompteEpargne lambda) {
        if(lambda!=null) {
            return DAL_CompteEpargne.creerCompteEpargne(lambda);
        }
        return false;
    }
    public static boolean supprimerCompteEpargne(int IdCompte){
        if(IdCompte!=0)
            return DAL_CompteEpargne.supprimerCompteEpargne(IdCompte);
        else
            return false;
    }
    public static boolean modifierSolde(double solde,int IdCompte){
        if(solde>=0.0)
            return DAL_CompteEpargne.modifierSolde(solde,IdCompte);
        else
            return false;
    }
    public static boolean depotArgent(double montant,int IdCompte){
        if(montant>=0.0)
            return DAL_CompteEpargne.depotArgent(montant,IdCompte);
        else
            return false;
    }
    public static boolean retrait(double montant,int IdCompte){
        if(montant>=0.0)
            return DAL_CompteEpargne.retrait(montant,IdCompte);
        else
            return false;
    }
}
