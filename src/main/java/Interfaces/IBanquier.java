package Interfaces;

import Models.entities.Banquier;

import java.util.ArrayList;

public abstract class IBanquier {
    public static Banquier getBanquier(int banquierID){return null;};

    public static ArrayList<Banquier> getAllBanquier(){return null;}

    public static boolean ajouterBanquier(Banquier lambda){return true;}

    public static boolean supprimerBanquier(int ID){return true;}

    public static boolean modifierBanquier(double salaire, int ID){return true;}
    public static boolean loginBanquier(String username,String password,int ID){return true;}

    public static boolean modifierNomBanquier(String nom, int ID){return true;}
    public static boolean modifierPrenomBanquier(String prenom , int ID){return true;}
    public static boolean modifierCINBanquier(String CIN, int ID){return true;}
    public static boolean modifierPasswordBanquier(String password, int ID){return true;}
    public static boolean modifierUsernameBanquier(String username, int ID){return true;}
    public static boolean modifierAdresseBanquier(String adresse, int ID){return true;}
    public static boolean modifierMailBanquier(String mail, int ID){return true;}

}
