package Models.entities;


import java.util.ArrayList;
import java.util.List;

public class CompteEpargne extends CompteBancaire{

    private double solde;

    private String datecreation;
    private int duree;

    public CompteEpargne(int idClient,int duree,TypeCompte type,String date){
        super(idClient,type);
        datecreation=date;
        this.solde=0.0;

        this.duree=duree;
    }
    public CompteEpargne(int id,int idClient,int duree,double solde,TypeCompte type,String date){
        super(id,idClient,type);
        datecreation=date;
        this.solde=solde;

        this.duree=duree;
    }


    @Override
    public void setSolde(double solde){
        this.solde=solde;
    }
    @Override
    public double getSolde(){
        return solde;
    }

    public void setDateCreation(String datecreation){
        this.datecreation=datecreation;
    }

    public String getDatecreation(){
        return datecreation;
    }

    public void setDuree(int duree){
        this.duree= duree;
    }

    public int getDuree(){
        return duree;
    }

    public String toString(){
        return super.toString() +" ,Solde: "+solde+",Date de creation du compte: "+datecreation+",Durée: "+duree+" ";
    }
}
