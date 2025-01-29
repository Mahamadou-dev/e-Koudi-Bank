package Models.entities;


import Models.entities.*;
import java.sql.*;
import Models.blls.*;
import Controllers.*;
import Models.dals.*;


public class GestionBase {
    private static Connection connection;

    // Connexion à la base de données
    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BanqueDB", "root", "88778095");
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }


    // Méthode pour récupérer les données de la base de données et les mettre dans les listes
    public static void loadDataFromDataBase() {
        connect(); // Ouvrir la connexion
        if (connection == null) {
            System.out.println("Impossible d'établir une connexion à la base de données.");
            return;
        }
       /*  // Charger la banque
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Banque");
            if (rs.next()) {
                Banque banque = new Banque(rs.getInt("idBanque"), rs.getString("nom"), rs.getString("adresse"));
                DataBase.banque = banque;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la banque : " + e.getMessage());
        } */

        // Charger les employés (Banquiers et Directeurs)
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employe");
            while (rs.next()) {
                int idEmploye = rs.getInt("idEmploye");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String dateNais = rs.getString("dateNais");
                String CIN = rs.getString("CIN");
                String tel = rs.getString("tel");
                String adresse = rs.getString("adresse");
                String mail = rs.getString("mail");
                double salaire = rs.getDouble("salaire");

                // Créer un Employe
                Employe employe = new Employe(idEmploye, nom, prenom, dateNais, CIN, tel, adresse, mail, salaire);

                // Vérifier si c'est un Banquier ou un Directeur
                try (PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM Banquier WHERE idBanquier = ?")) {
                    stmt2.setInt(1, idEmploye);
                    ResultSet rsBanquier = stmt2.executeQuery();
                    if (rsBanquier.next()) {
                        Banquier banquier = new Banquier(idEmploye, nom, prenom, dateNais, CIN, tel, adresse, mail, salaire,
                                rsBanquier.getString("username"), rsBanquier.getString("password"));
                        DataBase.banquiers.add(banquier);
                    } else {
                        try (PreparedStatement stmt3 = connection.prepareStatement("SELECT * FROM Directeur WHERE idDirecteur = ?")) {
                            stmt3.setInt(1, idEmploye);
                            ResultSet rsDirecteur = stmt3.executeQuery();
                            if (rsDirecteur.next()) {
                                Directeur directeur = new Directeur(idEmploye, nom, prenom, dateNais, CIN, tel, adresse, mail, salaire,
                                        rsDirecteur.getString("username"), rsDirecteur.getString("password"));
                                /*DataBase. directeur=directeur ;*/
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des employés : " + e.getMessage());
        }
        System.out.println("Bien pour les employess : " );
        // Charger les clients
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Client");
            while (rs.next()) {
                System.out.println("A la recuperation================================="+rs.getString("dateNais"));
                Client client = new Client(rs.getInt("idClient"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("dateNais"), rs.getString("CIN"), rs.getString("tel"),
                        rs.getString("adresse"), rs.getString("mail"),rs.getDouble("soldePret"),rs.getString("username"),rs.getString("password"));
                DataBase.clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }
        System.out.println("Bien pour les clients : " );

        // Charger les comptes bancaires
// Charger les comptes bancaires avec leurs détails
        try (Statement stmt = connection.createStatement()) {
            // Requête pour récupérer les comptes épargnes avec leurs détails
            String queryEpargne = """
        SELECT cb.idCompte, cb.idClient, cb.typeCompte, ce.duree, ce.solde, ce.dateCreation
        FROM CompteBancaire cb
        INNER JOIN CompteEpargne ce ON cb.idCompte = ce.idCompte
    """;
            ResultSet rsEpargne = stmt.executeQuery(queryEpargne);
            while (rsEpargne.next()) {
                int idCompte = rsEpargne.getInt("idCompte");
                int idClient = rsEpargne.getInt("idClient");
                int duree = rsEpargne.getInt("duree");
                double solde = rsEpargne.getDouble("solde");
                String dateCreation = rsEpargne.getString("dateCreation");
                String typeCompte = rsEpargne.getString("typeCompte").toUpperCase();

                // Créer l'objet CompteEpargne et l'ajouter à la liste
                CompteEpargne compteEpargne = new CompteEpargne(
                        idCompte, idClient, duree, solde, TypeCompte.valueOf(typeCompte), dateCreation
                );
                DataBase.compteEpargnes.add(compteEpargne);
            }

            // Requête pour récupérer les comptes courants avec leurs détails
            String queryCourant = """
        SELECT cb.idCompte, cb.idClient, cb.typeCompte, cc.solde, cc.dateCreation
        FROM CompteBancaire cb
        INNER JOIN CompteCourant cc ON cb.idCompte = cc.idCompte
    """;
            ResultSet rsCourant = stmt.executeQuery(queryCourant);
            while (rsCourant.next()) {
                int idCompte = rsCourant.getInt("idCompte");
                int idClient = rsCourant.getInt("idClient");
                double solde = rsCourant.getDouble("solde");
                String dateCreation = rsCourant.getString("dateCreation");
                String typeCompte = rsCourant.getString("typeCompte").toUpperCase();

                // Créer l'objet CompteCourant et l'ajouter à la liste
                CompteCourant compteCourant = new CompteCourant(
                        idCompte, idClient, solde, dateCreation, TypeCompte.valueOf(typeCompte)
                );
                DataBase.compteCourants.add(compteCourant);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des comptes bancaires : " + e.getMessage());
        }
        System.out.println("Récupération des comptes terminée avec succès.");

        System.out.println("Bien pour les comptes : " );

        // Charger les transactions
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Transaction");
            while (rs.next()) {
                Transaction transaction = new Transaction(rs.getInt("idTransaction"), rs.getString("type"),
                        rs.getDouble("montant"), rs.getString("date"), rs.getInt("idCompte"));
                DataBase.transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des transactions : " + e.getMessage());
        }finally {
            close(); // Fermer la connexion
        }
    }


    // Méthode pour vider les tables et insérer les données des listes dans la base de données
    public static void updateDataBase() {
        connect();
        if (connection == null) {
            System.out.println("Impossible d'établir une connexion à la base de données.");
            return;
        }

        try {
            // Vider les tables et réinitialiser AUTO_INCREMENT
            Statement stmt = connection.createStatement();

            // Supprimer les données des tables
            stmt.executeUpdate("DELETE FROM Transaction");
            stmt.executeUpdate("ALTER TABLE Transaction AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM CompteEpargne");
            stmt.executeUpdate("ALTER TABLE CompteEpargne AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM CompteCourant");
            stmt.executeUpdate("ALTER TABLE CompteCourant AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM CompteBancaire");
            stmt.executeUpdate("ALTER TABLE CompteBancaire AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM Client");
            stmt.executeUpdate("ALTER TABLE Client AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM Banquier");
            stmt.executeUpdate("ALTER TABLE Banquier AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM Directeur");
            stmt.executeUpdate("ALTER TABLE Directeur AUTO_INCREMENT = 1");

            stmt.executeUpdate("DELETE FROM Employe");
            stmt.executeUpdate("ALTER TABLE Employe AUTO_INCREMENT = 1");

            System.out.println("Vidage et réinitialisation du compteur terminés.");

            // Insérer le Directeur
            if (DataBase.directeur != null) {
                PreparedStatement psEmploye = connection.prepareStatement(
                        "INSERT INTO Employe (nom, prenom, dateNais, CIN, tel, adresse, mail, salaire) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
                psEmploye.setString(1, DataBase.directeur.getNom());
                psEmploye.setString(2, DataBase.directeur.getPrenom());
                psEmploye.setString(3, DataBase.directeur.getDateNais());
                psEmploye.setString(4, DataBase.directeur.getCIN());
                psEmploye.setString(5, DataBase.directeur.getTel());
                psEmploye.setString(6, DataBase.directeur.getAdresse());
                psEmploye.setString(7, DataBase.directeur.getMail());
                psEmploye.setDouble(8, DataBase.directeur.getSalaire());
                psEmploye.executeUpdate();

                ResultSet rsEmploye = psEmploye.getGeneratedKeys();
                if (rsEmploye.next()) {
                    int idEmploye = rsEmploye.getInt(1);

                    // Insérer dans Directeur
                    PreparedStatement psDirecteur = connection.prepareStatement(
                            "INSERT INTO Directeur (idDirecteur, username, password) VALUES (?, ?, ?)"
                    );
                    psDirecteur.setInt(1, idEmploye); // idDirecteur = idEmploye
                    psDirecteur.setString(2, DataBase.directeur.getUsername());
                    psDirecteur.setString(3, DataBase.directeur.getPassword());
                    psDirecteur.executeUpdate();
                }
            }
            System.out.println("Insertion du directeur terminée.");
            // Insérer les Employés
            for (Banquier banquier : DataBase.banquiers) {
                System.out.println("Insertion du banquier : " + banquier);
                // Étape 1 : Insérer dans Employe
                PreparedStatement psEmploye = connection.prepareStatement(
                        "INSERT INTO Employe (nom, prenom, dateNais, CIN, tel, adresse, mail, salaire) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
                psEmploye.setString(1, banquier.getNom());
                psEmploye.setString(2, banquier.getPrenom());
                psEmploye.setString(3, banquier.getDateNais());
                psEmploye.setString(4, banquier.getCIN());
                psEmploye.setString(5, banquier.getTel());
                psEmploye.setString(6, banquier.getAdresse());
                psEmploye.setString(7, banquier.getMail());
                psEmploye.setDouble(8, banquier.getSalaire());
                psEmploye.executeUpdate();

                // Récupérer l'idEmploye généré
                ResultSet rsEmploye = psEmploye.getGeneratedKeys();
                if (rsEmploye.next()) {
                    int idEmploye = rsEmploye.getInt(1);

                    // Étape 2 : Insérer dans Banquier
                    PreparedStatement psBanquier = connection.prepareStatement(
                            "INSERT INTO Banquier (idBanquier, idDirecteur, username, password) VALUES (?, 1, ?, ?)"
                    );
                    psBanquier.setInt(1, idEmploye); // idBanquier = idEmploye
                    psBanquier.setString(2, banquier.getUsername());
                    psBanquier.setString(3, banquier.getPassword());
                    psBanquier.executeUpdate();
                }
            }
            System.out.println("Insertion des banquiers terminée.");
            // Insertion de clients
            for (Client client : DataBase.clients) {
                PreparedStatement psClient = connection.prepareStatement(
                        "INSERT INTO Client (nom, prenom, dateNais, CIN, tel, adresse, mail,idBanquier,soldePret,username,password) VALUES (?, ?, ?, ?, ?, ?, ?,2,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                );
                System.out.println("A l'insertion===================================="+client.getDateNais());
                psClient.setString(1, client.getNom());
                psClient.setString(2, client.getPrenom());
                psClient.setString(3, client.getDateNais());
                psClient.setString(4, client.getCIN());
                psClient.setString(5, client.getTel());
                psClient.setString(6, client.getAdresse());
                psClient.setString(7, client.getMail());
                psClient.setDouble(8, client.getSoldePret());
                psClient.setString(9, client.getUsername());
                psClient.setString(10, client.getPassword());
                psClient.executeUpdate();

                ResultSet rsClient = psClient.getGeneratedKeys();
                if (rsClient.next()) {
                    int idClient = rsClient.getInt(1);
                    client.setId(idClient); // Mettez à jour l'id du client dans l'objet Client
                }
            }
            System.out.println("Insertion des clients terminée.");
            // Insertion des comptes bancaires
            try {
                connection.setAutoCommit(false); // Démarrer une transaction

                // Insertion des comptes courants
                for (CompteCourant compteCourant : DataBase.compteCourants) {
                    try (PreparedStatement psBancaire = connection.prepareStatement(
                            "INSERT INTO CompteBancaire (idClient, typeCompte) VALUES (?, 'COURANT')",
                            Statement.RETURN_GENERATED_KEYS)) {
                        System.out.println("Ici Data Management, insertion\n  ccourant dans la base=== "+compteCourant.toString());
                        // Étape 1 : Insérer dans CompteBancaire
                        psBancaire.setInt(1, compteCourant.getIdClient());
                        psBancaire.executeUpdate();

                        // Récupérer l'ID généré
                        try (ResultSet rsBancaire = psBancaire.getGeneratedKeys()) {
                            if (rsBancaire.next()) {
                                int idCompte = rsBancaire.getInt(1);
                                compteCourant.setIdCompte(idCompte); // Mettez à jour l'ID du compte

                                // Étape 2 : Insérer dans CompteCourant
                                try (PreparedStatement psCourant = connection.prepareStatement(
                                        "INSERT INTO CompteCourant (idCompte, solde, dateCreation) VALUES (?, ?, ?)")) {
                                    psCourant.setInt(1, idCompte);
                                    psCourant.setDouble(2, compteCourant.getSolde());
                                    psCourant.setString(3, compteCourant.getDatecreation());
                                    psCourant.executeUpdate();
                                }
                            }
                        }
                    } catch (SQLException e) {
                        System.err.println("Erreur lors de l'insertion du compte courant : " + e.getMessage());
                        throw e; // Réémettez l'erreur pour rollback
                    }
                }

                // Insertion des comptes épargnes
                for (CompteEpargne compteEpargne : DataBase.compteEpargnes) {
                    try (PreparedStatement psBancaire = connection.prepareStatement(
                            "INSERT INTO CompteBancaire (idClient, typeCompte) VALUES (?, 'EPARGNE')",
                            Statement.RETURN_GENERATED_KEYS)) {

                        // Étape 1 : Insérer dans CompteBancaire
                        psBancaire.setInt(1, compteEpargne.getIdClient());
                        psBancaire.executeUpdate();

                        // Récupérer l'ID généré
                        try (ResultSet rsBancaire = psBancaire.getGeneratedKeys()) {
                            if (rsBancaire.next()) {
                                int idCompte = rsBancaire.getInt(1);
                                compteEpargne.setIdCompte(idCompte); // Mettez à jour l'ID du compte

                                // Étape 2 : Insérer dans CompteEpargne
                                try (PreparedStatement psEpargne = connection.prepareStatement(
                                        "INSERT INTO CompteEpargne (idCompte, solde, dateCreation, duree) VALUES (?, ?, ?, ?)")) {
                                    psEpargne.setInt(1, idCompte);
                                    psEpargne.setDouble(2, compteEpargne.getSolde());
                                    psEpargne.setString(3, compteEpargne.getDatecreation());
                                    psEpargne.setInt(4, compteEpargne.getDuree());
                                    psEpargne.executeUpdate();
                                }
                            }
                        }
                    } catch (SQLException e) {
                        System.err.println("Erreur lors de l'insertion du compte épargne : " + e.getMessage());
                        throw e; // Réémettez l'erreur pour rollback
                    }
                }

                connection.commit(); // Valider la transaction
            } catch (SQLException e) {
                try {
                    connection.rollback(); // Annuler la transaction en cas d'erreur
                    System.err.println("Transaction annulée : " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    System.err.println("Erreur lors du rollback : " + rollbackEx.getMessage());
                }
            } finally {
                connection.setAutoCommit(true); // Restaurez le mode auto-commit
            }

            System.out.println("Insertion des comptes terminée.");
            //Les Transactions
            for (Transaction transaction : DataBase.transactions) {
                try (PreparedStatement psTransaction = connection.prepareStatement(
                        "INSERT INTO Transaction (type, montant, date, idCompte) VALUES (?, ?, ?, ?)")) {
                    psTransaction.setString(1, transaction.getType());
                    psTransaction.setDouble(2, transaction.getMontant());
                    psTransaction.setString(3, transaction.getDate());
                    psTransaction.setInt(4, transaction.getIdCompte());
                    System.out.println("ici data management La  transac qui va etre mise a jour======."+transaction.toString());
                    psTransaction.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Erreur lors de l'insertion de la transaction : " + e.getMessage());
                }
            }
            System.out.println("Insertion des transactions terminée.");






        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de la base de données : " + e.getMessage());
        } finally {
            close(); // Fermer la connexion
        }
    }

}

