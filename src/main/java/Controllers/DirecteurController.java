package Controllers;
import javax.swing.*;

import Models.blls.BLL_Banquier;
import Models.blls.BLL_Directeur;
import Models.entities.Banquier;
import Models.entities.Directeur;

import java.awt.*;
import java.awt.event.*;
import Models.blls.BLL_Directeur;
import java.util.Scanner;

public class DirecteurController {
    public static final Scanner scanner= new Scanner(System.in);
    public static boolean loginDirecteur(String username, String password, int id){
       /*  System.out.print(" entrer le nom d'utilisateur: "); String usernamed=scanner.nextLine();
        System.out.print("\n entrer le mot de passe : "); String passwordd=scanner.nextLine();
        System.out.print("\n entrer l'id: ");int idd= scanner.nextInt();scanner.nextLine();*/
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
            return BLL_Directeur.loginDirecteur(username,password,id);

    }
    public static Directeur getDirecteur(int id){

        if(id <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_Directeur.getDirecteur(id);
    }
    public static boolean modifierDirecteur(String nom,String prenom,String dateNais,String cin,String tel,String adresse,String mail,String username,String password,int id){
        boolean a= modifierNomDirecteur(nom, id);
        boolean b=  modifierPrenomDirecteur(prenom,id);
        boolean c= modifierDateNaisDirecteur(dateNais,id);
        boolean d=  modifierCINDirecteur(cin,id);
        boolean e=  modifierTelDirecteur(tel,id);
        boolean f=  modifierAdresseDirecteur(adresse, id);
        boolean g= modifierMailDirecteur(mail,id);
        boolean h=  modifierUsernameDirecteur(username,id);
        boolean i=  modifierPasswordDirecteur(password,id);
        return (a&b&c&d&e&f&g&h&i);
    }
    public static boolean modifierNomDirecteur(String nom,int id){
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
            return BLL_Directeur.modifierNomDirecteur(nom,id);

    }
    public static boolean modifierPrenomDirecteur(String prenom,int id){
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
            return BLL_Directeur.modifierPrenomDirecteur(prenom,id);

    }
    public static boolean modifierCINDirecteur(String cin,int id) {

        if(cin ==null) {
            System.out.println("CIN invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierCINDirecteur(cin,id);

    }
    public static boolean modifierPasswordDirecteur(String password,int id){

        if(password ==null) {
            System.out.println("mot de passe  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierPasswordDirecteur(password,id);

    }
    public static boolean modifierUsernameDirecteur(String username,int id){

        if(username ==null) {
            System.out.println("nom d'utilisateur  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierUsernameDirecteur(username,id);

    }

    public static boolean modifierAdresseDirecteur(String adresse,int id){

        if(adresse ==null) {
            System.out.println("adresse  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierAdresseDirecteur(adresse,id);

    }
    public static boolean modifierMailDirecteur(String mail,int id) {

        if(mail ==null) {
            System.out.println("mail  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierMailDirecteur(mail,id);

    }
    public static boolean modifierTelDirecteur(String tel,int id){

        if(tel ==null) {
            System.out.println("tel  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierTelDirecteur(tel,id);

    }
    public static boolean modifierDateNaisDirecteur(String dateNais,int id){

        if(dateNais ==null) {
            System.out.println("date de naissance  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Directeur.modifierDateNaisDirecteur(dateNais,id);

    }




}



