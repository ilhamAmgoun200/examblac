package org.laboratory.examblanc.daoImpl;

import org.laboratory.examblanc.dao.MembreDAO;
import org.laboratory.examblanc.models.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAOImpl implements MembreDAO {
    private Connection connection;

    // Constructeur pour initialiser la connexion à la base de données
    public MembreDAOImpl(Connection connection) {
        this.connection = connection;
    }

    // Implémentation de la méthode ajouterMembre de l'interface MembreDAO
    @Override
    public boolean ajouterMembre(Membre membre) {
        String sql = "INSERT INTO Membre (identifiant, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, membre.getIdentifiant());
            stmt.setString(2, membre.getNom());
            stmt.setString(3, membre.getPrenom());
            stmt.setString(4, membre.getEmail());
            stmt.setString(5, membre.getPhone());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Implémentation de la méthode getMembreByIdentifiant de l'interface MembreDAO
    @Override
    public Membre getMembreByIdentifiant(String identifiant) {
        String sql = "SELECT * FROM Membre WHERE identifiant = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identifiant);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                return new Membre(identifiant, nom, prenom, email, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Implémentation de la méthode getAllMembres de l'interface MembreDAO
    @Override
    public List<Membre> getAllMembres() {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM Membre";
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String identifiant = resultSet.getString("identifiant");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                membres.add(new Membre(identifiant, nom, prenom, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membres;
    }

    // Implémentation de la méthode supprimerMembre de l'interface MembreDAO
    @Override
    public boolean supprimerMembre(String identifiant) {
        String sql = "DELETE FROM Membre WHERE identifiant = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identifiant);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Implémentation de la méthode mettreAJourMembre de l'interface MembreDAO
    @Override
    public boolean mettreAJourMembre(Membre membre) {
        String sql = "UPDATE Membre SET nom = ?, prenom = ?, email = ?, phone = ? WHERE identifiant = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, membre.getNom());
            stmt.setString(2, membre.getPrenom());
            stmt.setString(3, membre.getEmail());
            stmt.setString(4, membre.getPhone());
            stmt.setString(5, membre.getIdentifiant());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
