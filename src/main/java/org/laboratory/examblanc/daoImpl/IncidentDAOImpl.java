package org.laboratory.examblanc.daoImpl;

import org.laboratory.examblanc.dao.IncidentDAO;
import org.laboratory.examblanc.models.Incident;
import org.laboratory.examblanc.models.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncidentDAOImpl implements IncidentDAO {
    private Connection connection;

    // Constructeur pour initialiser la connexion à la base de données
    public IncidentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean ajouterIncident(Incident incident) {
        String sql = "INSERT INTO Incident (reference, time, status, identifiant) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, incident.getReference());
            stmt.setString(2, incident.getTime());
            stmt.setString(3, incident.getStatus());
            stmt.setString(4, incident.getMembre().getIdentifiant());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Incident> getIncidentsByMembre(Membre membre) {
        List<Incident> incidents = new ArrayList<>();
        String sql = "SELECT * FROM Incident WHERE identifiant = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, membre.getIdentifiant());
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String reference = resultSet.getString("reference");
                String time = resultSet.getString("time");
                String status = resultSet.getString("status");
                incidents.add(new Incident(reference, time, status, membre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }
}
