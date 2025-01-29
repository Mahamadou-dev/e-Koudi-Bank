package Models.blls;

import Models.dals.DAL_Banque;
import Models.entities.CompteBancaire;

public class BLL_Banque {
    public static int nombreBanquiers() {return DAL_Banque.nombreBanquiers();}

    public static int nombreClients() {return DAL_Banque.nombreClients();}

    public static String infosBanque() {return DAL_Banque.infosBanque() ;}

    public static void afficherToutClient(){DAL_Banque.afficherToutClient();}

    public static void afficherToutBanquier(){DAL_Banque.afficherToutBanquier();}
    public static boolean transfert(double montant,CompteBancaire C1,CompteBancaire C2){
        if(C1==null|| C2==null||montant<0)
            return false;
        return DAL_Banque.transfert(montant, C1, C2);
    }
}
