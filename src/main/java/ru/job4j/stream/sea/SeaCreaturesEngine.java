package ru.job4j.stream.sea;

import java.util.*;

public class SeaCreaturesEngine {
    public void printSpeciesOld(List<SeaCreature> seaCreatures) {
        Set<Species> speciesSet = new HashSet<>();
        for (SeaCreature sc : seaCreatures) {
            if (sc.getWeight() >= 10) {
                speciesSet.add(sc.getSpecies());
            }
        }
        List<Species> sortedSpecies = new ArrayList<>(speciesSet);
        Collections.sort(sortedSpecies, new Comparator<Species>() {
            public int compare(Species a, Species b) {
                return Long.compare(a.getPopulation(), b.getPopulation());
            }
        });
        for (Species s : sortedSpecies) {
            System.out.println(s);
        }
    }

    public void printSpeciesNew(List<SeaCreature> seaCreatures) {
        seaCreatures.stream()
                .filter(sc -> sc.getWeight() >= 10)
                .map(SeaCreature::getSpecies)
                .distinct()
                .sorted(Comparator.comparing(Species::getPopulation))
                .map(Species::getName)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<SeaCreature> seaCreatureList
                = List.of(
                new SeaCreature(100_000_000.0, new Species(1_000, "Whale")),
                new SeaCreature(10.0, new Species(1_500_000_0, "Sea Cucumber")),
                new SeaCreature(1.0, new Species(1_000_000_00, "Anemone")),
                new SeaCreature(100_000_000.0, new Species(1_000, "Whale")),
                new SeaCreature(10, new Species(1_000_000_000, "Small fish")),
                new SeaCreature(100, new Species(1_000_000_0, "Big fish"))
                );

        SeaCreaturesEngine seaCreaturesEngine = new SeaCreaturesEngine();
        seaCreaturesEngine.printSpeciesOld(seaCreatureList);

        System.out.println();
        seaCreaturesEngine.printSpeciesNew(seaCreatureList);
    }
}
