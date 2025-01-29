package Models.blls;
import Models.dals.DAL_Banquier;
import Models.dals.DAL_Directeur;



import Models.dals.DAL_Directeur;
import Models.entities.Banquier;
import Models.entities.DataBase;
import Models.entities.Directeur;
import Models.entities.Directeur;

public class BLL_Directeur {
    public static boolean loginDirecteur(String username,String password,int ID){return DAL_Directeur.loginDirecteur(username,password,ID);}


    public static boolean modifierNomDirecteur(String nom, int ID) {return DAL_Directeur.modifierNomDirecteur(nom,ID);}


    public static boolean modifierPrenomDirecteur(String prenom, int ID) {return DAL_Directeur.modifierPrenomDirecteur(prenom,ID);}


    public static boolean modifierCINDirecteur(String CIN, int ID) {return DAL_Directeur.modifierCINDirecteur(CIN,ID);}


    public static boolean modifierPasswordDirecteur(String password, int ID) {return DAL_Directeur.modifierPasswordDirecteur(password,ID);}


    public static boolean modifierUsernameDirecteur(String username, int ID) {return DAL_Directeur.modifierUsernameDirecteur(username,ID);}
    public static Directeur getDirecteur(int lambda){return DAL_Directeur.getDirecteur(lambda);}

    public static boolean modifierAdresseDirecteur(String adresse, int ID) {return DAL_Directeur.modifierAdresseDirecteur(adresse,ID);}


    public static boolean modifierMailDirecteur(String mail,int ID) {return DAL_Directeur.modifierMailDirecteur(mail,ID);}
    public static boolean modifierTelDirecteur(String tel,int ID) {return DAL_Directeur.modifiertelDirecteur(tel,ID);}
    public static boolean modifierDateNaisDirecteur(String dateNais,int ID) {return DAL_Directeur.modifierDateNaisDirecteur(dateNais,ID);}

}


