package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void whenFirst1And1SecondMinus2And0ThirdMinus2AndMinus2Then14Dot485() {
        Point a = new Point(1, 1);
        Point b = new Point(-2, 4);
        Point c = new Point(-2, -2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 9;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void whenFirst5And5Second0And0Third10And10ThenMinus1() {
        Point a = new Point(5, 5);
        Point b = new Point(0, 0);
        Point c = new Point(10, 10);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}