package Models.blls;

import Models.dals.DAL_Banquier;

import Models.dals.DAL_Banquier;
import Models.entities.Banquier;
import Models.entities.DataBase;

import java.util.ArrayList;


public class BLL_Banquier {

    public static Banquier getBanquier(int lambda){return DAL_Banquier.getBanquier(lambda);}


    public static ArrayList<Banquier> getAllBanquier() {return DAL_Banquier.getAllBanquier();}


    public static boolean ajouterBanquier(Banquier lambda) {
        if(lambda!=null) {
            return DAL_Banquier.ajouterBanquier(lambda);
        }
        return false;
    }


    public static boolean supprimerBanquier(int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier  introuvable!!!");
            return false;
        }
        try {
            DataBase.banquiers.remove(lambda);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }

    public static boolean modifierSalaireBanquier(double salaire,int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }

        try {
            lambda.setSalaire(salaire);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean loginBanquier(String username,String password,int ID){
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }else
            return DAL_Banquier.loginBanquier(username,password,ID);

    }


    public static boolean modifierNomBanquier(String nom, int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setNom(nom);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierPrenomBanquier(String prenom, int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setPrenom(prenom);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierCINBanquier(String CIN, int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setCIN(CIN);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }


    public static boolean modifierPasswordBanquier(String password, int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setPassword(password);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierUsernameBanquier(String username, int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setUsername(username);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierAdresseBanquier(String adresse, int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setAdresse(adresse);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierMailBanquier(String mail,int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setMail(mail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean modifierTelBanquier(String tel,int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setTel(tel);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean modifierDateNaisBanquier(String dateNais,int ID) {
        Banquier lambda=getBanquier(ID);
        if(lambda==null) {
            System.out.println("Banquier introuvable!!!");
            return false;
        }
        try {
            lambda.setDateNais(dateNais);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
