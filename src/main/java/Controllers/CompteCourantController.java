package Controllers;

import java.util.ArrayList;

import Models.blls.BLL_CompteCourant;
import Models.blls.BLL_CompteEpargne;
import Models.entities.CompteCourant;
import Models.entities.TypeCompte;


public class CompteCourantController {
    public static CompteCourant getCompteCourant(int idClient){
        if(idClient <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_CompteCourant.getCompteCourant(idClient);
    }
    public static CompteCourant getCompteCourantByIdCompte(int idCompte){
        if(idCompte <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_CompteCourant.getCompteCourantByIdCompte(idCompte);
    }
    public static ArrayList<CompteCourant> getAllCompteCourant() {return BLL_CompteCourant.getAllCompteCourant();}
    public static boolean creerCompteCourant(int idClient,TypeCompte type,String date) {

        CompteCourant B=new CompteCourant(idClient,date,type);
        return BLL_CompteCourant.creerCompteCourant(B);

    }

    public static boolean supprimerCompteCourant(int IdCompte){
        return BLL_CompteCourant.supprimerCompteCourant(IdCompte);
    }

    public static boolean modifierSolde(double solde,int IdCompte){return BLL_CompteCourant.modifierSolde(solde,IdCompte); }
    public static boolean depotArgent(double solde,int IdCompte){return BLL_CompteCourant.depotArgent(solde,IdCompte); }
    public static boolean retrait(double solde,int IdCompte){return BLL_CompteCourant.retrait(solde,IdCompte); }
}
