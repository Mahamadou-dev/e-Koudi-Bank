package Models.entities;

import java.util.ArrayList;
import java.util.List;

public class CompteCourant extends CompteBancaire{

    private double solde;

    private String datecreation;




    public CompteCourant(int idClient,String datecreation,TypeCompte type){
        super(idClient,type);
        this.solde=0.0;

        this.datecreation=datecreation;
    }
    public CompteCourant(int id,int idClient,double solde,String datecreation,TypeCompte type){
        super(id,idClient,type);
        this.solde=solde;

        this.datecreation=datecreation;
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
    @Override
    public String getDatecreation(){
        return datecreation;
    }

    public String toString(){
        return super.toString()+" Solde: "+solde+"Date de creation du compte: "+datecreation ;
    }
}