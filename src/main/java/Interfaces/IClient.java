package Interfaces;
import Models.entities.Client;
import java.util.ArrayList;

public abstract class IClient {
    public static Client getClient(int clientID){return null;};

    public static ArrayList<Client> getAllClient(){return null;}

    public static boolean ajouterClient(Client lambda){return true;}

    public static boolean supprimerClient(int ID){return true;}

    public static boolean modifierClient(double salaire, int ID){return true;}
    public static double preter(double montant){return 0.0;}
    public static double rembourser(double montant){return 0.0;}
    public static boolean loginClient(String username,String password,int ID){return true;}

    public static boolean modifierNomClient(String nom, int ID){return true;}
    public static boolean modifierPrenomClient(String prenom , int ID){return true;}
    public static boolean modifierCINClient(String CIN, int ID){return true;}
    public static boolean modifierPasswordClient(String password, int ID){return true;}
    public static boolean modifierUsernameClient(String username, int ID){return true;}
    public static boolean modifierAdresseClient(String adresse, int ID){return true;}
    public static boolean modifierMailClient(String mail, int ID){return true;}

}
