package ru.job4j.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public Map<String, Citizen> getCitizens() {
        return citizens;
    }

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        String passport = citizen.getPassport();
        if (!citizens.containsKey(passport)) {
            citizens.put(passport, citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }

    public static void main(String[] args) {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen citizen2 = new Citizen("2f44a", "Ivan Ivanov");
        office.add(citizen2);
        office.citizens
                .entrySet()
                .forEach((entry) -> System.out.println("key " + entry.getKey() + " value " + entry.getValue()));
        //citizens.merge()
    }
}