package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PassportOfficeWithComputeIfAbsent {
    private Map<String, Citizen> citizens = new HashMap<>();

    public Map<String, Citizen> getCitizens() {
        return citizens;
    }

    /**
     * @param citizen
     * @return Метод add вернет true, если пользователя еще нет в HashMap. Если он уже есть, то вернуть false.
     */

    public boolean add(Citizen citizen) {
        String passport = citizen.getPassport();
        Citizen oldCitizen = citizens.get(passport);
        boolean rsl = false;
        Citizen citizen1 = null;
        if (oldCitizen == null) {
            Map<String, Citizen> citizensCopy = new HashMap<>(citizens);
            citizen1 = citizensCopy
                    .computeIfAbsent(passport, key -> citizens.put(passport, citizen));
            rsl = true;
        }
        return !Objects.equals(citizen1, oldCitizen);
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }

    public static void main(String[] args) {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOfficeWithComputeIfAbsent office = new PassportOfficeWithComputeIfAbsent();
        System.out.println(office.add(citizen));
        System.out.println("after first addition");
        office.getCitizens()
                .entrySet()
                .forEach((entry) -> System.out.println("key " + entry.getKey() + " value " + entry.getValue()));
        Citizen citizen2 = new Citizen("2f44a", "Ivan Ivanov");
        System.out.println(office.add(citizen2));
        System.out.println("after second addition");
        office.getCitizens()
                .entrySet()
                .forEach((entry) -> System.out.println("key " + entry.getKey() + " value " + entry.getValue()));
    }
}