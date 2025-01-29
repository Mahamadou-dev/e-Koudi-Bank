
package utils;

public class Session {

    private static int userId = 0; // Stocke l'ID de l'utilisateur connecté

    // Méthode pour définir l'ID de l'utilisateur
    public static void setUserId(int id) {
        userId = id;
    }

    // Méthode pour récupérer l'ID de l'utilisateur
    public static int getUserId() {
        return userId;
    }

    // Méthode pour vérifier si un utilisateur est connecté
    public static boolean isLoggedIn() {
        return userId != 0;
    }

    // Méthode pour réinitialiser la session (utile pour la déconnexion)
    public static void clear() {
        userId = 0;
    }


}
