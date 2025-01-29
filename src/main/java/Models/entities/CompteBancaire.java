package Models.entities;

public abstract class CompteBancaire {
    private int idClient;
    private TypeCompte type;
    private int idCompte;
    private static int compteur = 0;
    public CompteBancaire(int idClient,TypeCompte type){
        this.idClient=idClient;

        this.type=type;
        if(DataBase.verifierCompte(compteur + 1)) {
            if (type == TypeCompte.COURANT) {
                if (DataBase.compteCourants.getLast().getIdCompte() == (compteur + 1))
                    this.idCompte = (++compteur) + 1;
                else
                    this.idCompte = DataBase.compteCourants.getLast().getIdCompte() + 1;
            } else {
                if (DataBase.compteEpargnes.getLast().getIdCompte() == (compteur + 1))
                    this.idCompte = (++compteur) + 1;
                else
                    this.idCompte = DataBase.compteEpargnes.getLast().getIdCompte() + 1;
            }
        }else {
            idCompte = ++compteur;
        }
    }
    public CompteBancaire(int id,int idClient,TypeCompte type){
        this.idClient=idClient;
        idCompte= id;
        this.type=type;
    }

    public int  getIdCompte(){
        return idCompte;
    }
    public void setIdClient(int idClient){
        this.idClient=idClient;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public int getIdClient(){
        return idClient;
    }
    public TypeCompte getType(){return type;}
    public void setType(TypeCompte T){type=T;}
    @Override
    public String toString(){
        return "ID compte"+idCompte+"Id Client: "+idClient+",Type="+type;
    }

    public  double getSolde(){
        return 0.0;
    };

    public  String getDatecreation(){
        return "01/01/2000";
    };

    public  void setSolde(double d1){
        System.out.println("Rien!!!");
    }
}
