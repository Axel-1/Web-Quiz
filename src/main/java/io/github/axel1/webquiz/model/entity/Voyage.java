package io.github.axel1.webquiz.model.entity;

import java.util.Objects;

public class Voyage {
    private Internaute internaute;
    private String ville;
    private String dateDepart;
    private IAppreciation appreciation;

    public Voyage(Internaute internaute, String ville, String dateDepart, IAppreciation appreciation) {
        this.internaute = internaute;
        this.ville = ville;
        this.dateDepart = dateDepart;
        this.appreciation = appreciation;
    }

    public Internaute getInternaute() {
        return internaute;
    }

    public void setInternaute(Internaute internaute) {
        this.internaute = internaute;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public IAppreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(IAppreciation appreciation) {
        this.appreciation = appreciation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voyage voyage = (Voyage) o;
        return internaute.equals(voyage.internaute) && ville.equals(voyage.ville) && dateDepart.equals(voyage.dateDepart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internaute, ville, dateDepart);
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "internaute=" + internaute +
                ", ville='" + ville + '\'' +
                ", dateDepart=" + dateDepart +
                '}';
    }
}
