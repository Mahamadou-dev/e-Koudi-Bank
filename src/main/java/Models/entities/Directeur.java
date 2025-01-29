package Models.entities;
public class Directeur extends Employe{
    private String password;
    private String username;

    public Directeur(String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail,double salaire,String password,String username){
        super(nom,prenom,dateNais,CIN,tel,adresse,mail,salaire);
        this.password=password;
        this.username=username;
    }
    public Directeur(int id,String nom,String prenom,String dateNais,String CIN,String tel,String adresse,String mail,double salaire,String password,String username){
        super(id,nom,prenom,dateNais,CIN,tel,adresse,mail,salaire);
        this.password=password;
        this.username=username;
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

    public String toString(){
        return super.toString()+"UserName: "+username+"    Password:"+password+"\n";
    }

}
