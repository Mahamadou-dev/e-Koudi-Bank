package Models.dals;

import Interfaces.IBanquier;
import Models.entities.Banquier;
import Models.entities.DataBase;
import java.util.ArrayList;

public  abstract class DAL_Banquier extends IBanquier {

    public static Banquier getBanquier(int lambda) {
        Banquier result = null;
        for(Banquier b:DataBase.banquiers){
            if(b.getId()==lambda) {
                result = b;
                break;
            }
        }
        return result;
    }


    public static ArrayList<Banquier> getAllBanquier() {
        return DataBase.banquiers;
    }


    public static boolean ajouterBanquier(Banquier lambda) {

        int i = 0;
        for (Banquier b : DataBase.banquiers) {
            if (b.getCIN().equals(lambda.getCIN()))
                i++;
        }
        if (i == 0) {
            DataBase.banquiers.add(lambda);
            return true;
        }

        return false;
    }


    public static boolean supprimerBanquier(int ID) {
        Banquier lambda=getBanquier(ID);

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
        System.out.println("Trouvé");
        try {
            boolean a=(lambda.getUsername().equals(username));
            System.out.println("usnm"+a);
            boolean b=(lambda.getPassword().equals(password));
            System.out.println("usnm"+b);
            return (a&&b);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static boolean modifierNomBanquier(String nom, int ID) {
        Banquier lambda=getBanquier(ID);
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
        try {
            lambda.setMail(mail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean modifiertelBanquier(String tel,int ID) {
        Banquier lambda=getBanquier(ID);
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
        try {
            lambda.setDateNais(dateNais);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
