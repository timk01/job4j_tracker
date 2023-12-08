package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void firstCharIsNumberAndSymbol() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "1vanov",
                "Ivanov"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void firstCharIsSymbolAndNumber() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "4vanov"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void firstCharOfFirstWordIsSEmptyAndSymbol() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                "v"
        );
        assertThat(rst).isLessThan(0);
    }


    @Test
    public void firstCharOfSecondWordIsSEmptyAndSymbol() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "v",
                ""
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void firstCharOfSecondWordIsSEmptyAndNumber() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                "3"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void firstCharOfFirstWordIsSEmptyAndNumber() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "3",
                ""
        );
        assertThat(rst).isGreaterThan(0);
    }


    @Test
    public void wordsAreSameNumbersAndSameSize() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "12345",
                "12345"
        );
        assertThat(rst).isEven();
    }

    @Test
    public void wordsAreDifferentNumbersAndSameSize() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "12345",
                "12340"
        );
        assertThat(rst).isPositive();
    }

    @Test
    public void secondWordIsBiggerThanFirst() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "12345",
                "123450"
        );
        assertThat(rst).isNegative();
    }

    @Test
    public void firstWordIsBiggerThanSecond() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "123450",
                "12345"
        );
        assertThat(rst).isPositive();
    }

    @Test
    public void bothWordsHaveMixedSymbolsAndNumbers() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "123abc",
                "123abc"
        );
        assertThat(rst).isEven();
    }
}