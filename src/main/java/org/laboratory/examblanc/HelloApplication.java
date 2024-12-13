package org.laboratory.examblanc;
import org.laboratory.examblanc.dao.IncidentDAO;
import org.laboratory.examblanc.dao.MembreDAO;
import org.laboratory.examblanc.daoImpl.IncidentDAOImpl;
import org.laboratory.examblanc.daoImpl.MembreDAOImpl;
import org.laboratory.examblanc.models.Incident;
import org.laboratory.examblanc.models.Membre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HelloApplication {

    public static void main(String[] args) {
        try {
            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/gestionincidents"; // Remplacez "votre_base" par le nom de votre base de données
            String user = "root";  // Remplacez par votre nom d'utilisateur MySQL
            String password = "";  // Remplacez par votre mot de passe MySQL
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données réussie !");

            // Création des objets DAO
            MembreDAO membreDAO = new MembreDAOImpl(connection);
            IncidentDAO incidentDAO = new IncidentDAOImpl(connection);

            // Création d'un membre
            Membre membre = new Membre("M12553", "Jofehn", "Dofe", "john.dofe@example.com", "12fe3456789");
            if (membreDAO.ajouterMembre(membre)) {
                System.out.println("Membre ajouté avec succès !");
            } else {
                System.out.println("Échec de l'ajout du membre.");
            }

            // Création d'un incident pour ce membre
            Incident incident = new Incident("I001", "2024-12-13 14:00", "Résolu", membre);
            if (incidentDAO.ajouterIncident(incident)) {
                System.out.println("Incident ajouté avec succès !");
            } else {
                System.out.println("Échec de l'ajout de l'incident.");
            }

            // Récupération des incidents du membre
            List<Incident> incidents = incidentDAO.getIncidentsByMembre(membre);
            if (incidents != null && !incidents.isEmpty()) {
                System.out.println("Incidents pour le membre " + membre.getIdentifiant() + ":");
                for (Incident inc : incidents) {
                    System.out.println("Référence: " + inc.getReference() + ", Heure: " + inc.getTime() + ", Statut: " + inc.getStatus());
                }
            } else {
                System.out.println("Aucun incident trouvé pour ce membre.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion ou de manipulation de la base de données.");
        }
    }
}
