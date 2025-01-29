package Models.entities;

public  class Employe extends Personne {
    private int id;
    private double salaire;

    private static int ide = 0;

    public Employe(String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail,double salaire){
        super(nom,prenom,CIN,dateNais,tel,adresse,mail);
        if(DataBase.verifierBanquier(ide +1)) {
            if(DataBase.banquiers.getLast().getId()==(ide+1))
                this.id = (++ide) + 1;
            else
                this.id=DataBase.banquiers.getLast().getId()+1;
        }else{
            this.id=++ide;
        }
        this.salaire=salaire;
    }
    public Employe(int id,String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail,double salaire){
        super(nom,prenom,CIN,dateNais,tel,adresse,mail);
        this.id=id;
        this.salaire=salaire;
    }

    public void setSalaire(double salaire){
        this.salaire=salaire;
    }
    public double getSalaire(){
        return salaire;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "Les informations du personnel:\n"+super.toString() + "\nId Personnel="+id+"    ";
    }

}
