package Models.entities;

public class Transaction {
    private int idTransaction;
    private String type;
    private double montant;
    private String date;
    int idCompte;
    private static int idc=0;


    /*public Transaction( String type, double montant, String date) {
        this.idTransaction = ++idc;
        this.type = type;
        this.montant = montant;
        this.date = date;
    }*/
    public Transaction(int id, String type, double montant, String date,int idcompt) {
        this.idTransaction = id;
        this.type = type;
        this.idCompte=idcompt;
        this.montant = montant;
        this.date = date;
    }
    public Transaction( String type, double montant, String date,int idCompte) {
        if(DataBase.verifierTransaction(idc +1)) {
            if(DataBase.transactions.getLast().getIdTransaction()==(idc+1))
              this.idTransaction = (++idc) + 1;
            else
                this.idTransaction=DataBase.transactions.getLast().getIdTransaction()+1;
        }else {
            this.idTransaction = ++idc;
        }
        this.type = type;
        this.idCompte=idCompte;
        this.montant = montant;
        this.date = date;
    }


    public void setType(String type){
        this.type=type;
    }
    public void setMontant(double montant){
        this.montant=montant;
    }
    public void setDate(String date){
        this.date=date;
    }

    public int getIdTransaction(){
        return idTransaction;
    }
    public int getIdCompte(){
        return idCompte;
    }
    public String getType(){
        return type;
    }
    public double getMontant(){
        return montant;
    }
    public String getDate(){
        return date;
    }




    public void afficherTransaction() {
        System.out.println("ID Transaction: " + idTransaction);
        System.out.println("Type: " + type);
        System.out.println("Montant: " + montant);
        System.out.println("Date: " + date);
    }

    public String toString(){
        return "ID Transaction: "+idTransaction+", Type: "+type+", Montant: "+montant+", Date"+ date;
    }
}
