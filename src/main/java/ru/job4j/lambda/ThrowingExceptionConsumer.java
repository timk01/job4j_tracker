package ru.job4j.lambda;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;

    static int something(Consumer consumer, int number) {
        try {
            consumer.accept(number);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

