package Controllers;

import java.util.ArrayList;

import Models.blls.BLL_Banque;
import Models.blls.BLL_Banquier;
import Models.dals.DAL_Banque;
import Models.entities.Banquier;
import Models.entities.CompteBancaire;
import Models.entities.CompteCourant;
import Models.entities.CompteEpargne;
import Models.entities.DataBase;
import Models.entities.Directeur;


public class BanqueController {
    public static int nombreBanquiers() {return BLL_Banque.nombreBanquiers();}

    public static int nombreClients() {return BLL_Banque.nombreClients();}


    public static String infossBanque() {return BLL_Banque.infosBanque() ;}

    public static String infosBanque(){return DataBase.directeur.toString()+"\n"+infossBanque()+"\nNombre de clients="+nombreClients()+"\nNombre de banquiers="+nombreBanquiers();}
    public static void afficherToutClient(){BLL_Banque.afficherToutClient();}
    public static void afficherToutBanquier(){BLL_Banque.afficherToutBanquier();}
    public static CompteBancaire getCompteBancaire(int idClient){

        CompteCourant Cc=CompteCourantController.getCompteCourant(idClient);
        CompteEpargne Ce=CompteEpargneController.getCompteEpargne(idClient);
        if(Cc==null){
            return Ce;
        }
        else if(Ce==null){
            return Cc;
        }
        else
            return null;

    }
    public static CompteBancaire getCompteBancaireByIdCompte(int idCompte){

        CompteCourant Cc=CompteCourantController.getCompteCourantByIdCompte(idCompte);
        CompteEpargne Ce=CompteEpargneController.getCompteEpargneByIdCompte(idCompte);
        if(Cc==null){
            return Ce;
        }
        else if(Ce==null){
            return Cc;
        }
        else
            return null;

    }
    public static boolean supprimerClient(int idClient){
        boolean a=TransactionController.supprimerTransactions(idClient);
        boolean b=false;CompteBancaire C=getCompteBancaire(idClient);
        if(C instanceof CompteEpargne){
            b=CompteEpargneController.supprimerCompteEpargne(C.getIdCompte());
        } else if(C instanceof CompteCourant) {
            b=CompteCourantController.supprimerCompteCourant(C.getIdCompte());
        }
        boolean c=ClientController.supprimerClient(idClient);
        return (a&&b&&c);

    }
    public static ArrayList<CompteBancaire> getAllComptesBancaires() {
        ArrayList<CompteBancaire> L =new ArrayList<>(CompteCourantController.getAllCompteCourant());

        L.addAll(CompteEpargneController.getAllCompteEpargne());
        return L;
    }
    public static boolean transfert(double montant,CompteBancaire C1,CompteBancaire C2){return BLL_Banque.transfert(montant, C1, C2);}
    public static boolean existanceCompte(int idClient){
      CompteBancaire C=getCompteBancaire(idClient);
      boolean result;
        result= C == null;
      return result;
    }
}
