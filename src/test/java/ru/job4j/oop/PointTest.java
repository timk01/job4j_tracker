package ru.job4j.oop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void whenFirstIs0And0WhileSecondIs2And0Then2dot0() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 0);
        double out = point1.distance(point2);
        double expected = 2.0;
        double precision = 0.0001;
        assertThat(out).isEqualTo(expected, withPrecision(precision));
    }

    @Test
    void whenFirstIsMinus2And2WhileSecondIs4And9Then9dot2195() {
        Point point1 = new Point(-2, 2);
        Point point2 = new Point(4, 9);
        double out = point1.distance(point2);
        double expected = 9.2195;
        double precision = 0.0001;
        assertThat(out).isEqualTo(expected, withPrecision(precision));
    }

    @Test
    void whenFirstIs2And0WhileSecondIsMinus4And3Then6dot7082() {
        Point point1 = new Point(2, 0);
        Point point2 = new Point(-4, 3);
        double out = point1.distance(point2);
        double expected = 6.7082;
        double precision = 0.0001;
        assertThat(out).isEqualTo(expected, withPrecision(precision));
    }

    @Test
    void whenFirstIs1And2And3WhileSecondIs3And2And1Then2dot8284() {
        Point point1 = new Point(1, 2, 3);
        Point point2 = new Point(3, 2, 1);
        double out = point1.distance3d(point2);
        double expected = 2.8284;
        double precision = 0.0001;
        assertThat(out).isEqualTo(expected, withPrecision(precision));
    }

    @Test
    void whenFirstIsMinus1And2And3WhileSecondIs3AndMinus2And1Then5dot7445() {
        Point point1 = new Point(-1, 2, 0);
        Point point2 = new Point(3, -2, 1);
        double out = point1.distance3d(point2);
        double expected = 5.7445;
        double precision = 0.0001;
        assertThat(out).isEqualTo(expected, withPrecision(precision));
    }

    @Test
    void infoTest() {
        int x = 0;
        int y = 0;
        Point point1 = new Point(x, y);
        point1.info();
        String actual = "Point[" + x + ", " + y + "]";
        assertThat(actual).isEqualTo(outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}