package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    void calcThrowsExc() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> fact.calc(-1)
        );
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    void calcWorksNormally() {
        Fact fact = new Fact();
        int result = fact.calc(3);
        int expected = 6;
        assertThat(result).isEqualTo(expected);
    }
}