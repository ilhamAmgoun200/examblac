package org.laboratory.examblanc.models;
import java.util.Random;  // Ajoutez cette ligne en haut de votre fichier pour importer Random

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private List<Incident> incidents;  // Liste d'incidents associée à ce membre

    // Constructeur
    public Membre(String identifiant, String nom, String prenom, String email, String phone) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents = new ArrayList<>();  // Initialisation de la liste des incidents
    }

    // Getters et Setters
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    // Ajouter un incident à la liste
    public void ajouterIncident(Incident incident) {
        this.incidents.add(incident);
    }

    // Redéfinition de la méthode equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Membre membre = (Membre) obj;
        return Objects.equals(identifiant, membre.identifiant);
    }

    // Redéfinition de la méthode hashCode
    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }

    // Méthode pour générer un identifiant aléatoire
    public String genererIdentifiant() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder identifiant = new StringBuilder();
        Random rand = new Random();  // Correctement importée ici

        for (int i = 0; i < 10; i++) {
            identifiant.append(alphabet.charAt(rand.nextInt(alphabet.length())));  // Utilisation correcte de nextInt
        }

        return identifiant.toString();
    }
}
