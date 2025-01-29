package Controllers;

import java.util.ArrayList;

import Models.blls.BLL_CompteEpargne;
import Models.blls.BLL_CompteEpargne;
import Models.dals.DAL_CompteEpargne;
import Models.entities.CompteEpargne;
import Models.entities.CompteEpargne;
import Models.entities.TypeCompte;


public class CompteEpargneController {
    public static CompteEpargne getCompteEpargne(int IdClient){
        if(IdClient <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_CompteEpargne.getCompteEpargne(IdClient);
    }
    public static CompteEpargne getCompteEpargneByIdCompte(int idCompte){
        if(idCompte <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_CompteEpargne.getCompteEpargneByIdCompte(idCompte);
    }
    public static ArrayList<CompteEpargne> getAllCompteEpargne() {return BLL_CompteEpargne.getAllCompteEpargne();}
    public static boolean creerCompteEpargne(int idClient,int duree,TypeCompte type,String date) {

        CompteEpargne B=new CompteEpargne(idClient,duree,type,date);
        return BLL_CompteEpargne.creerCompteEpargne(B);
    }
    public static boolean supprimerCompteEpargne(int IdCompte){
        return BLL_CompteEpargne.supprimerCompteEpargne(IdCompte);
    }
    public static boolean modifierSolde(double solde,int IdCompte){return BLL_CompteEpargne.modifierSolde(solde,IdCompte); }
    public static boolean depotArgent(double solde,int IdCompte){return BLL_CompteEpargne.depotArgent(solde,IdCompte); }
    public static boolean retrait(double solde,int IdCompte){return BLL_CompteEpargne.retrait(solde,IdCompte); }


}
