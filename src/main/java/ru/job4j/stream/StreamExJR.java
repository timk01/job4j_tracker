package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExJR {
    public static void main(String[] args) {
        Stream<Object> empty = Stream.empty();
        System.out.println(empty.count());

        Stream.Builder<Integer> numBuilder = Stream.builder();
        numBuilder.add(1).add(2).add(3);
        Stream<Integer> build = numBuilder.build();

        Stream<Integer> numStream = Stream.of(1, 2, 3);

        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> numStream2 = Arrays.stream(arr);

        Stream<Integer> numStream3 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> numStream4 = Stream.of(1, 2, 3);
        Stream<Integer> combinedStream = Stream.concat(numStream3, numStream4);

        Stream<Integer> numStreamEx = Stream.of(43, 65, 1, 98, 63);
        List<Integer> even = numStreamEx
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(even);

        Stream<Integer> numStreamEx2 = Stream.of(43, 65, 1, 98, 63);
        List<Integer> d = numStreamEx2
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(d);

        Stream<Integer> numStreamRepeat = Stream.of(43, 65, 1, 98, 63, 63, 1);
        List<Integer> numList = numStreamRepeat.distinct().collect(Collectors.toList());
        System.out.println(numList);

        Stream<Integer> numStreamPeek = Stream.of(43, 65, 1, 98, 63);
        List<Integer> nList = numStreamPeek
                .map(n -> n * 10)
                .peek(n -> System.out.println("Mapped: " + n))
                .collect(Collectors.toList());
        System.out.println(nList);

        Stream<Integer> numStreamSorted = Stream.of(43, 65, 1, 98, 63);
        numStreamSorted
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .forEach(System.out::println);

        Stream<Integer> numStreamCount = Stream.of(43, 65, 1, 98, 63);
        System.out.println(numStreamCount.count());

        Stream<Integer> numbs = Stream.of(43, 65, 1, 98, 63);
        List<Integer> odd = numbs
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toList());
        System.out.println(odd);

        numStream = Stream.of(43, 65, 1, 98, 63);
        int largest = numStream
                .max(Integer::compare)
                .get();
        System.out.println("Largest element: " + largest);

        System.out.println();
        Stream<Integer> numStreamOpt = Stream.of(43, 65, 1, 98, 63);
        Optional<Integer> opt = numStreamOpt
                .findFirst();
        System.out.println(opt);
        numStream = Stream.empty();
        opt = numStream.findAny();
        System.out.println(opt);

        Stream<Integer> numStreamOptAny = Stream.of(43, 65, 1, 98, 63);
        boolean b = numStreamOptAny.anyMatch(n -> n == 1);
        System.out.println("found el with == 1 " + b);
    }
}
