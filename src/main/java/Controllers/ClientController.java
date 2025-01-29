package Controllers;
import javax.swing.*;

import Models.blls.BLL_Client;
import Models.blls.BLL_Client;
import Models.blls.BLL_Client;
import Models.blls.BLL_Client;
import Models.entities.Client;
import Models.entities.Client;
import Models.entities.Client;
import Models.entities.Client;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import Models.blls.BLL_Client;
import Models.entities.Client;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ClientController {

    public static boolean preter(double montant,int id){
        /*System.out.print(" entrer le montant : "); double montant=scanner.nextDouble();scanner.nextLine();
        System.out.print("\n entrer l'id: ");int id= scanner.nextInt();scanner.nextLine();*/
        if(montant <=0) {
            System.out.println("montant  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        return BLL_Client.preter(montant,id);
    }
    public static boolean rembourser(double montant,int id){
        /*System.out.print(" entrer le montant : "); double montant=scanner.nextDouble();scanner.nextLine();
        System.out.print("\n entrer l'id: ");int id= scanner.nextInt();scanner.nextLine();*/
        if(montant <=0) {
            System.out.println("montant  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        return BLL_Client.rembourser(montant,id);
    }
    public static Client getClient(int lambda){

        if(lambda <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_Client.getClient(lambda);
    }

    public static ArrayList<Client> getAllClient() {return BLL_Client.getAllClient();}
    public static boolean ajouterClient(Client C) {

        return BLL_Client.ajouterClient(C);

    }
    public static boolean modifierClient(String nom,String prenom,String dateNais,String cin,String tel,String adresse,String mail,String username,String password,int id){
        boolean a= modifierNomClient(nom, id);
        boolean b=  modifierPrenomClient(prenom,id);
        boolean c= modifierDateNaisClient(dateNais,id);
        boolean d=  modifierCINClient(cin,id);
        boolean e=  modifierTelClient(tel,id);
        boolean f=  modifierAdresseClient(adresse, id);
        boolean g= modifierMailClient(mail,id);
        boolean h=  modifierUsernameClient(username,id);
        boolean i=  modifierPasswordClient(password,id);
        return (a&b&c&d&e&f&g&h&i);
    }
    public static boolean ajouterClient(String nom,String prenom,String dateNais,String cin,String tel,String adresse,String mail,String username,String password) {

        Client B=new Client(nom,prenom,dateNais,cin,tel,adresse,mail,username,password);
        return BLL_Client.ajouterClient(B);

    }
    public static boolean supprimerClient(int id){

        if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        return BLL_Client.supprimerClient(id);
    }

    public static boolean loginClient(String username, String password,int id){
        /*System.out.print(" entrer le nom d'utilisateur: "); String username=scanner.nextLine();
        System.out.print("\n entrer le mot de passe : "); String password=scanner.nextLine();
        System.out.print("\n entrer l'id: ");int id= scanner.nextInt();scanner.nextLine();*/
        if(username == null) {
            System.out.println("nom d'utilisateur invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else if(password == null){
            System.out.println("Le mot de passe invalide !!!");
            return false;
        }
        else
            return BLL_Client.loginClient(username,password,id);

    }
    public static boolean modifierNomClient(String nom,int id){
        /*System.out.print("   entrer le nom: "); String nom=scanner.nextLine();
        System.out.print("\n entrer l'id: ");int id= scanner.nextInt();scanner.nextLine();*/
        if(nom ==null) {
            System.out.println("nom invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierNomClient(nom,id);

    }
    public static boolean modifierPrenomClient(String prenom,int id){
       /*  System.out.print("   entrer le prenom: "); String prenom =scanner.nextLine();
        System.out.print("\n entrer l'id: ");int id= scanner.nextInt();scanner.nextLine();*/
        if(prenom ==null) {
            System.out.println("prenom invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierPrenomClient(prenom,id);

    }
    public static boolean modifierCINClient(String cin,int id) {

        if(cin ==null) {
            System.out.println("CIN invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierCINClient(cin,id);

    }
    public static boolean modifierPasswordClient(String password,int id){

        if(password ==null) {
            System.out.println("mot de passe  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierPasswordClient(password,id);

    }
    public static boolean modifierUsernameClient(String username,int id){

        if(username ==null) {
            System.out.println("nom d'utilisateur  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierUsernameClient(username,id);

    }

    public static boolean modifierAdresseClient(String adresse,int id){

        if(adresse ==null) {
            System.out.println("adresse  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierAdresseClient(adresse,id);

    }
    public static boolean modifierMailClient(String mail,int id) {

        if(mail ==null) {
            System.out.println("mail  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierMailClient(mail,id);

    }
    public static boolean modifierTelClient(String tel,int id){

        if(tel ==null) {
            System.out.println("tel  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierTelClient(tel,id);

    }
    public static boolean modifierDateNaisClient(String dateNais,int id){

        if(dateNais ==null) {
            System.out.println("date de naissance  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Client.modifierDateNaisClient(dateNais,id);

    }

}

