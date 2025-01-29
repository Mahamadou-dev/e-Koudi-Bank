package Models.dals;
import Models.entities.Banquier;
import Models.entities.Client;
import Models.entities.CompteBancaire;
import Interfaces.IBanque;
import Models.entities.Banque;
import Models.entities.DataBase;

public class DAL_Banque extends IBanque {

    public static int nombreBanquiers() {
        return DataBase.banquiers.size();
    }


    public static int nombreClients() {
        return DataBase.clients.size();
    }


    public static String infosBanque() {
        return Banque.infos() ;
    }
    public static void afficherToutClient(){
        for(Client C: Models.dals.DAL_Client.getAllClient()){
            System.out.println(C.toString());
        }
    }
    public static void afficherToutBanquier(){
        for(Banquier B:DAL_Banquier.getAllBanquier()){
            System.out.println(B.toString());
        }
    }
    public static boolean transfert(double montant,CompteBancaire C1,CompteBancaire C2){
        if((!C1.equals(null)) && (!C2.equals(null))){
            if(C1.getSolde()<montant)
                return false;
            else{
                double d1=C1.getSolde()-montant;
                C1.setSolde(d1);
                double d2=C2.getSolde()+montant;
                C2.setSolde(d2);
                return true;}
        }
        return false;
    }
}
