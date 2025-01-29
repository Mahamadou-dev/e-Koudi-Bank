package Controllers;
import javax.swing.*;

import Models.blls.BLL_Banquier;
import Models.entities.Banquier;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class BanquierController {
    private static final Scanner scanner = new Scanner(System.in);
    public static Banquier getBanquier(int lambda){

        if(lambda <=0) {
            System.out.println("L'id invalide !!!");
            return null;
        }
        return BLL_Banquier.getBanquier(lambda);
    }
    public static boolean modifierBanquier(String nom,String prenom,String dateNais,String cin,String tel,String adresse,String mail,String username,String password,int id){
        boolean a= modifierNomBanquier(nom, id);
        boolean b=  modifierPrenomBanquier(prenom,id);
        boolean c= modifierDateNaisBanquier(dateNais,id);
        boolean d=  modifierCINBanquier(cin,id);
        boolean e=  modifierTelBanquier(tel,id);
        boolean f=  modifierAdresseBanquier(adresse, id);
        boolean g= modifierMailBanquier(mail,id);
        boolean h=  modifierUsernameBanquier(username,id);
        boolean i=  modifierPasswordBanquier(password,id);
        return (a&b&c&d&e&f&g&h&i);
    }
    public static ArrayList<Banquier> getAllBanquier() {return BLL_Banquier.getAllBanquier();}
    public static boolean ajouterBanquier(String nom,String prenom,String dateNais,String cin,String tel,String adresse,String mail,double salaire,String username,String password) {

        Banquier B=new Banquier(nom,prenom,dateNais,cin,tel,adresse,mail,salaire,username,password);
        return BLL_Banquier.ajouterBanquier(B);

    }
    public static boolean supprimerBanquier(int id){

        if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        return BLL_Banquier.supprimerBanquier(id);
    }
    public static boolean modifierSalaireBanquier(double salaire,int id){

        if(salaire <=0) {
            System.out.println("Salaire  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierSalaireBanquier(salaire,id);

    }
    public static boolean loginBanquier(String username, String password,int id){
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
            return BLL_Banquier.loginBanquier(username,password,id);

    }
    public static boolean modifierNomBanquier(String nom,int id){
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
            return BLL_Banquier.modifierNomBanquier(nom,id);

    }
    public static boolean modifierPrenomBanquier(String prenom,int id){
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
            return BLL_Banquier.modifierPrenomBanquier(prenom,id);

    }
    public static boolean modifierCINBanquier(String cin,int id) {

        if(cin ==null) {
            System.out.println("CIN invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierCINBanquier(cin,id);

    }
    public static boolean modifierPasswordBanquier(String password,int id){

        if(password ==null) {
            System.out.println("mot de passe  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierPasswordBanquier(password,id);

    }
    public static boolean modifierUsernameBanquier(String username,int id){

        if(username ==null) {
            System.out.println("nom d'utilisateur  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierUsernameBanquier(username,id);

    }

    public static boolean modifierAdresseBanquier(String adresse,int id){

        if(adresse ==null) {
            System.out.println("adresse  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierAdresseBanquier(adresse,id);

    }
    public static boolean modifierMailBanquier(String mail,int id) {

        if(mail ==null) {
            System.out.println("mail  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierMailBanquier(mail,id);

    }
    public static boolean modifierTelBanquier(String tel,int id){

        if(tel ==null) {
            System.out.println("tel  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierTelBanquier(tel,id);

    }
    public static boolean modifierDateNaisBanquier(String dateNais,int id){

        if(dateNais ==null) {
            System.out.println("date de naissance  invalide !!!");
            return false;
        }
        else if(id <=0) {
            System.out.println("L'id invalide !!!");
            return false;
        }
        else
            return BLL_Banquier.modifierDateNaisBanquier(dateNais,id);

    }


}
