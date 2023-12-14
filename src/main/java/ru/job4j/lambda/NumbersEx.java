package ru.job4j.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NumbersEx {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(throwingExceptionConsumerWrapper(n -> methodThrowingAnException(n)));
    }

    private static void methodThrowingAnException(Integer n) {
    }

    static <T> Consumer<T> throwingExceptionConsumerWrapper(
            ThrowingExceptionConsumer<T, Exception> throwingExceptionConsumer) {
        return x -> {
            try {
                throwingExceptionConsumer.accept(x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}


