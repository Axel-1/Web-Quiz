package io.github.axel1.webquiz.model.service;

import io.github.axel1.webquiz.model.entity.Internaute;

import java.util.ArrayList;
import java.util.List;

public class InternauteService {
    private static InternauteService instance;
    private final List<Internaute> internautes;

    private InternauteService() {
        this.internautes = new ArrayList<>();
    }

    public static InternauteService getInstance() {
        if (instance == null) {
            instance = new InternauteService();
        }
        return instance;
    }

    public Internaute getOrAddInternaute(String nom) {
        Internaute newInternaute = new Internaute(nom);
        if (internautes.isEmpty()) {
            internautes.add(newInternaute);
        }

        for (Internaute internaute : internautes) {
            if (internaute.equals(newInternaute)) {
                return internaute;
            }
        }

        this.internautes.add(newInternaute);
        return newInternaute;
    }
}
