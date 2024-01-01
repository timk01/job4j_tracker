package ru.job4j.stream.sea;

import java.util.Objects;
import java.util.StringJoiner;

public class Species {

    private long population;
    private String name;

    public Species(int population, String name) {
        this.population = population;
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Species species = (Species) o;
        return population == species.population && Objects.equals(name, species.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(population, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Species.class.getSimpleName() + "[", "]")
                .add("population=" + population)
                .add("name='" + name + "'")
                .toString();
    }
}
