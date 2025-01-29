package Models.entities;

public class Client extends Personne {
    private int id;
    private String password;
    private String username;
    private double pret;

    private static int idc=0;

    public Client(String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail,String username,String password){
        super(nom,prenom,dateNais,CIN,tel,adresse,mail);
        if(DataBase.verifierClient(idc +1)) {
            if(DataBase.clients.getLast().getId()==(idc+1))
                this.id = (++idc) + 1;
            else
                this.id=DataBase.clients.getLast().getId()+1;
        }else{
            this.id=++idc;
        }
        this.password=password;
        this.username=username;
        this.pret=0;

    }
    public Client(int id,String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail,double soldePret,String username,String password){
        super(nom,prenom,dateNais,CIN,tel,adresse,mail);
        this.id=id;
        this.password=password;
        this.username=username;
        this.pret=soldePret;

    }


    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public void setSoldePret(double pret){
        this.pret=pret;
    }
    public double getSoldePret(){
        return pret;
    }


    public String toString(){
        return "Les informations du client:\n"+super.toString()+"   Id Client="+id;
    }
}

