package Interfaces;

import Models.entities.CompteCourant;

import java.util.ArrayList;

public interface ICompteCourant {
    CompteCourant getCompte(int compteID);

    CompteCourant getCompte(int compteID, int clientID);

    ArrayList<CompteCourant> getAllCompte();

    ArrayList<CompteCourant> getAllCompte(int clientID);

    boolean ajouterCompte(CompteCourant compte);

    boolean supprimerCompte(int compteID);

    boolean updateCompte(int compteID, CompteCourant compte);

}
