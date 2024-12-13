package org.laboratory.examblanc.dao;

import org.laboratory.examblanc.models.Membre;
import java.util.List;

public interface MembreDAO {
    // Méthodes que vous devez implémenter
    boolean ajouterMembre(Membre membre);
    Membre getMembreByIdentifiant(String identifiant);
    List<Membre> getAllMembres();
    boolean supprimerMembre(String identifiant);
    boolean mettreAJourMembre(Membre membre);
}
