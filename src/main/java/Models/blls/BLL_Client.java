package Models.blls;

import Models.dals.DAL_Client;
import Models.entities.Client;
import Models.entities.DataBase;

import java.util.ArrayList;

public class BLL_Client {
    public static Client getClient(int lambda){return DAL_Client.getClient(lambda);}


    public static ArrayList<Client> getAllClient() {return DAL_Client.getAllClient();}


    public static boolean ajouterClient(Client lambda) {
        if (lambda != null){
            return DAL_Client.ajouterClient(lambda);
        }

        return false;
    }

    public static boolean supprimerClient(int ID) {
        Client lambda=getClient(ID);
        if(lambda==null) {
            System.out.println("Client introuvable!!!");
            return false;
        }
        try {
            DataBase.clients.remove(lambda);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }
    public static boolean preter(double montant,int clientID){
        Client lambda = getClient(clientID);
        if (lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
            return false;
        } else if (lambda.getSoldePret() < 0) {
            return false;
        }
        try {
            lambda.setSoldePret(montant);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean rembourser(double montant,int clientID){
        return DAL_Client.rembourser(montant, clientID);

    }

    public static boolean loginClient(String username,String password,int ID){
        Client lambda=getClient(ID);
        if(lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
            return false;
        }
        else
            return DAL_Client.loginClient(username,password,ID);
    }


    public static boolean modifierNomClient(String nom, int ID) {
        Client lambda=getClient(ID);
        if(lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
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


    public static boolean modifierPrenomClient(String prenom, int ID) {
        Client lambda=getClient(ID);
        if(lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
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


    public static boolean modifierCINClient(String CIN, int ID) {
        Client lambda=getClient(ID);
        if(lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
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


    public static boolean modifierPasswordClient(String password, int ID) {
        Client lambda=getClient(ID);
        if(lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
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


    public static boolean modifierUsernameClient(String username, int ID) {
        Client lambda=getClient(ID);
        if(lambda.equals(null)) {
            System.out.println("Client introuvable!!!");
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


    public static boolean modifierAdresseClient(String adresse, int ID) {
        Client lambda=getClient(ID);
        if(lambda==null) {
            System.out.println("Client introuvable!!!");
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


    public static boolean modifierMailClient(String mail,int ID) {
        Client lambda=getClient(ID);
        if(lambda==null) {
            System.out.println("Client introuvable!!!");
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
    public static boolean modifierTelClient(String tel,int ID) {
        Client lambda=getClient(ID);
        if(lambda==null) {
            System.out.println("Client introuvable!!!");
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
    public static boolean modifierDateNaisClient(String dateNais,int ID) {
        Client lambda=getClient(ID);
        if(lambda==null) {
            System.out.println("Client introuvable!!!");
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
