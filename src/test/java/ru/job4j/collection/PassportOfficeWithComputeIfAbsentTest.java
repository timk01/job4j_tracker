package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassportOfficeWithComputeIfAbsentTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOfficeWithComputeIfAbsent office = new PassportOfficeWithComputeIfAbsent();
        boolean result = office.add(citizen);
        assertThat(result).isTrue();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenCitizenPassportIsSame() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOfficeWithComputeIfAbsent office = new PassportOfficeWithComputeIfAbsent();
        office.add(citizen);
        Citizen citizen2 = new Citizen("2f44a", "Ivan Ivanov");
        boolean result = office.add(citizen2);
        assertThat(result).isFalse();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenFoundExistingPassport() {
        String passport = "2f44a";
        Citizen citizen = new Citizen(passport, "Petr Arsentev");
        PassportOfficeWithComputeIfAbsent office = new PassportOfficeWithComputeIfAbsent();
        office.add(citizen);
        assertThat(office.get(passport)).isEqualTo(citizen);
    }

    @Test
    public void whenIsNotFoundExistingPassport() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOfficeWithComputeIfAbsent office = new PassportOfficeWithComputeIfAbsent();
        office.add(citizen);
        assertThat(office.get("2f44b")).isNotEqualTo(citizen);
    }
}