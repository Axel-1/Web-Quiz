package io.github.axel1.webquiz.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Internaute {
    private String nom;
    private List<Voyage> voyages;

    public Internaute(String nom) {
        this.nom = nom;
        this.voyages = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public void addVoyage(Voyage voyage) {
        this.voyages.add(voyage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Internaute that = (Internaute) o;
        return nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Internaute{" +
                "nom='" + nom + '\'' +
                ", voyages=" + voyages +
                '}';
    }
}
