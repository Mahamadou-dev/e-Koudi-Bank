import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // URL JDBC pour MySQL
        String url = "jdbc:mysql://localhost:3306/BanqueDB"; // Remplacez 'banquebd' par le nom de votre base de données
        String user = "root"; // Remplacez par votre utilisateur
        String password = "88778095"; // Remplacez par votre mot de passe

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
