package ru.job4j.stream.sea;

import java.util.Objects;

public class SeaCreature {

    private double weight;
    private Species species;

    public SeaCreature(double weight, Species species) {
        this.weight = weight;
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public Species getSpecies() {
        return species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SeaCreature that = (SeaCreature) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(species, that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, species);
    }
}
