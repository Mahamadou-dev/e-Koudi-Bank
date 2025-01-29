package Models.dals;

import Models.entities.Banquier;
import Models.entities.Client;
import Models.entities.DataBase;
import Interfaces.IClient;

import java.util.ArrayList;

public class DAL_Client extends IClient{
    public static Client getClient(int clientID) {
        for (Client client : DataBase.clients) {
            if (client.getId() == clientID) { // Comparer avec l'ID du client
                return client; // Retourner l'objet exact
            }
        }
        return null; // Aucun client trouvé
    }



    public static ArrayList<Client> getAllClient() {
        return DataBase.clients;
    }


    public static boolean ajouterClient(Client lambda) {
        if(lambda!=null) {
            int i = 0;
            for (Client b : DataBase.clients) {
                if (b.getCIN().equals(lambda.getCIN()))
                    i++;
            }
            if (i == 0) {
                DataBase.clients.add(lambda);
                return true;
            }
        }
        return false;
    }


    public static boolean supprimerClient(int ID) {
        Client lambda=getClient(ID);

        try {
            DataBase.clients.remove(lambda);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }

    public static boolean preter(double montant,int clientID){
        Client C=getClient(clientID);
        if(C.getSoldePret()<0)
            return false;
        try {
            C.setSoldePret(montant);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean rembourser(double montant, int clientID) {
        // Récupérer le client
        Client C = getClient(clientID);

        // Vérifier si le client existe
        if (C == null) {
            System.out.println("Client introuvable pour l'ID : " + clientID);
            return false;
        }

        // Effectuer le remboursement
        if (montant >= C.getSoldePret()) {
            C.setSoldePret(0.0); // Le prêt est entièrement remboursé
            System.out.println("Apres"+C.getSoldePret());
            return true;
        } else if (montant > 0) {
            double nouveauSoldePret = C.getSoldePret() - montant;
            C.setSoldePret(nouveauSoldePret); // Réduction partielle du solde du prêt
            return true;
        } else {
            System.out.println("Le montant de remboursement doit être positif.");
            return false;
        }
    }


    public static boolean loginClient(String username,String password,int ID){
        Client lambda=getClient(ID);
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


    public static boolean modifierNomClient(String nom, int ID) {
        Client lambda=getClient(ID);
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
        try {
            lambda.setMail(mail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static boolean modifiertelClient(String tel,int ID) {
        Client lambda=getClient(ID);
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
        try {
            lambda.setDateNais(dateNais);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


}
