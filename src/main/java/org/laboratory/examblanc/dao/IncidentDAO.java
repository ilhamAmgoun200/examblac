package org.laboratory.examblanc.dao;

import org.laboratory.examblanc.models.Incident;
import org.laboratory.examblanc.models.Membre;

import java.util.List;

public interface IncidentDAO {
    boolean ajouterIncident(Incident incident);
    List<Incident> getIncidentsByMembre(Membre membre);
}

