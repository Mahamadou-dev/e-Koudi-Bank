package Models.entities;


public abstract class Personne {
    private String CIN;
    private String nom;
    private String prenom;
    private String adresse;
    private String dateNais;
    private String tel;
    private String mail;

    public Personne(String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail) {
        this.CIN=CIN;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.dateNais=dateNais;
        this.tel=tel;
        this.mail=mail;
    }

    public void setCIN(String CIN){
        this.CIN=CIN;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }
    public void setDateNais(String dateNais){
        this.dateNais=dateNais;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public void setMail(String mail){
        this.mail=mail;
    }

    public String getCIN(){
        return CIN;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getAdresse(){
        return adresse;
    }
    public String getDateNais(){
        return dateNais;
    }
    public String getTel(){
        return tel;
    }
    public String getMail(){
        return mail;
    }

    public String toString(){
        return "\nNom="+nom+"    Prenom="+prenom+"    Adresse="+adresse+", \nDate Naissance="+dateNais+"    Tel="+tel+"    mail="+mail;
    }
}
