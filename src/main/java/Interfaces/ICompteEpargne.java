package Interfaces;
import Models.entities.CompteEpargne;
import java.util.ArrayList;
public interface ICompteEpargne {

    CompteEpargne getCompte(long compteID);

    CompteEpargne getCompte(long compteID, long clientID);

    ArrayList<CompteEpargne> getAllCompte(long clientID);

    ArrayList<CompteEpargne> getAllCompte();

    boolean supprimerCompte(long compteID);

    boolean supprimerCompte(CompteEpargne compte);

    boolean ajouterCompte(CompteEpargne compte);

    boolean updateCompte(long compteID, CompteEpargne compte);
}