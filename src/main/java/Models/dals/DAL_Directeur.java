package Models.dals;
import Interfaces.IDirecteur;
import Models.entities.Directeur;
import Models.entities.Banquier;
import Models.entities.DataBase;

public class DAL_Directeur extends IDirecteur {

    public static boolean modifierNomDirecteur(String nom,int ID) {
        try {
            DataBase.directeur.setNom(nom);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static Directeur getDirecteur(int lambda) {
        Directeur result = null;
        result=DataBase.directeur;
        return result;
    }

    public static boolean modifierPrenomDirecteur(String prenom,int ID ){
        try {
            DataBase.directeur.setPrenom(prenom);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierCINDirecteur(String CIN,int ID) {

        try {
            DataBase.directeur.setCIN(CIN);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }


    public static boolean modifierPasswordDirecteur(String password,int ID) {

        try {
            DataBase.directeur.setPassword(password);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierUsernameDirecteur(String username,int ID) {

        try {
            DataBase.directeur.setUsername(username);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierAdresseDirecteur(String adresse,int ID) {

        try {
            DataBase.directeur.setAdresse(adresse);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static boolean modifierMailDirecteur(String mail,int ID) {

        try {
            DataBase.directeur.setMail(mail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean loginDirecteur(String username, String password, int id) {
        try {
            // Vérifiez que l'objet directeur est valide
            if (DataBase.directeur == null) {
                throw new Exception("Aucun directeur enregistré dans la base de données.");
            }

            // Comparer les valeurs des chaînes correctement
            boolean usernameMatch = DataBase.directeur.getUsername().equals(username);

            boolean passwordMatch = DataBase.directeur.getPassword().equals(password);

            boolean idMatch = DataBase.directeur.getId() == id;


            return usernameMatch && passwordMatch && idMatch;
        } catch (Exception e) {
            System.out.println("Erreur lors de la tentative de connexion : " + e.getMessage());
            return false;
        }
    }

    public static boolean modifiertelDirecteur(String tel,int ID) {

        try {
            DataBase.directeur.setTel(tel);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean modifierDateNaisDirecteur(String dateNais,int ID) {

        try {
            DataBase.directeur.setDateNais(dateNais);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }




}
