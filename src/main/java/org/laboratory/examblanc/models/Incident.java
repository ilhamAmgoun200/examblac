package org.laboratory.examblanc.models;

import java.util.Objects;

public class Incident {

    private String reference;
    private String time;
    private String status;
    private Membre membre;  // Référence au membre qui a déclenché cet incident

    // Constructeur
    public Incident(String reference, String time, String status, Membre membre) {
        this.reference = reference;
        this.time = time;
        this.status = status;
        this.membre = membre;
    }

    // Getters et Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
