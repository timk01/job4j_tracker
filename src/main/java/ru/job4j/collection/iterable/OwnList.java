package ru.job4j.collection.iterable;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * No need to write iterator (as well as listIterator) if you write get()
 * <p>
 * In reality, for better performance our methods should also implement class RandomAccess and since
 * for method it's not viable, see the class (private one) below
 * <p>
 * Plus, again, we can do better than default contains() and add indexOf(), lastIndexOf()
 * methods since they work with iterators
 * since iterators ARE slow! (they begin from 1 or last element and go through all list)
 * <p>
 * Plus, reDo sublist() ((it's good enough already, tho))
 * and stream(), parallelStrem(), which use splitIterator by default
 *
 * PS: in general, or you write less by using only Abstact-classes but it can have some nuances,
 * or you write more but it's much better if your write your own classes or share library
 */

public class OwnList {

    static List<Integer> rangeList(int fromInclusive, int toInclusive) {
        return new RangeList(fromInclusive, toInclusive);
    }

    private static class RangeList extends AbstractList<Integer> implements RandomAccess {

        private final int fromInclusive;
        private final int toInclusive;

        public RangeList(int fromInclusive, int toInclusive) {
            this.fromInclusive = fromInclusive;
            this.toInclusive = toInclusive;
        }

        @Override
        public int size() {
            return toInclusive - fromInclusive;
        }

        @Override
        public Integer get(int index) {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException(index);
            }
            return fromInclusive + index;
        }

        @Override
        public boolean contains(Object o) {
            return o instanceof Integer
                    && ((Integer) o) >= fromInclusive
                    && ((Integer) o) < toInclusive;
        }

        @Override
        public int indexOf(Object o) {
            if (contains(o)) {
                return (Integer) (o) - fromInclusive;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            return indexOf(o);
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            }
            if (toIndex > size()) {
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            }
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException("fromIndex(" + fromIndex
                        + ") > toIndex(" + toIndex + ")");
            }
            return new RangeList(fromInclusive + fromIndex, fromInclusive + toIndex);
        }

        @Override
        public Stream<Integer> stream() {
            return IntStream.range(fromInclusive, toInclusive).boxed();
        }

        @Override
        public Stream<Integer> parallelStream() {
            return stream().parallel();
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = rangeList(5, 10);
        System.out.println(integerList);
        System.out.println(integerList.get(2));
        System.out.println(integerList.get(0));

        System.out.println(integerList.subList(2, 4));
    }
}
