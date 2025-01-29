package Models.entities;

public class Banque {
    private static String nom="e-koudi Bank";
    private static String adresse="Rue 100e Omrane Monastir, Tunisie";
    static int id=1;

    // Constructeur privé pour éviter toute instanciation
    private Banque() {
    }
   /* public Banque(int id,String nom,String adresse){
        this.id=id;
        this.nom=nom;
        this.adresse=adresse;
    } */

    // Méthodes statiques pour gérer les attributs de la banque
    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Banque.nom = nom;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static void setAdresse(String adresse) {
        Banque.adresse = adresse;
    }

    // Méthode pour afficher les informations
    public static String infos() {
        return "Nom de la Banque= " + nom + "Adresse= " + adresse+"\n";
    }
}
