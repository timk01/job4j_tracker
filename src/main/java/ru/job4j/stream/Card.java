package ru.job4j.stream;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
                .add("suit=" + suit)
                .add("value=" + value)
                .toString();
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                        .map(value -> new Card(suit1, value)))
                .forEach(System.out::println);
    }
}
