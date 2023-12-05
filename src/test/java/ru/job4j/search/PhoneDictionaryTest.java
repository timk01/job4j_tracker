package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    public void whenNothingIsFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Arsentev", "100500", "Ivanovo")
        );
        ArrayList<Person> persons = phones.find("100501");
        assertThat(persons).isEmpty();
    }

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindBySurnameSeveralPersons() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Arsentev", "100500", "Ivanovo")
        );
        ArrayList<Person> persons = phones.find("Arsentev");
        assertThat(persons).hasSize(2);
        assertThat(persons.get(1).getName()).isEqualTo("Ivan");
    }
}
