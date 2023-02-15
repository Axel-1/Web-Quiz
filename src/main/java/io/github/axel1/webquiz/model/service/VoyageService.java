package io.github.axel1.webquiz.model.service;

import io.github.axel1.webquiz.model.entity.IAppreciation;
import io.github.axel1.webquiz.model.entity.Internaute;
import io.github.axel1.webquiz.model.entity.Voyage;

import java.util.ArrayList;
import java.util.List;

public class VoyageService {
    private static VoyageService instance;
    private final List<Voyage> voyages;

    private VoyageService() {
        this.voyages = new ArrayList<>();
    }

    public static VoyageService getInstance() {
        if (instance == null) {
            instance = new VoyageService();
        }
        return instance;
    }

    public void addVoyage(Internaute internaute, String ville, String date, IAppreciation appreciation) {
        Voyage newVoyage = new Voyage(internaute, ville, date, appreciation);

        if (!voyages.isEmpty()) {
            for (Voyage voyage : voyages) {
                if (voyage.equals(newVoyage)) {
                    throw new IllegalArgumentException("Voyage déjà existant");
                }
            }
        }

        voyages.add(newVoyage);
        internaute.addVoyage(newVoyage);
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public List<Voyage> getVoyagesByVille(String ville) {
        List<Voyage> voyageResult = new ArrayList<>();
        for (Voyage voyage : this.voyages) {
            if (voyage.getVille().equals(ville)) {
                voyageResult.add(voyage);
            }
        }
        return voyageResult;
    }
}
