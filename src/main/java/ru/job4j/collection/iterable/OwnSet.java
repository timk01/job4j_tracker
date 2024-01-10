package ru.job4j.collection.iterable;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * here we go: abstract set internally extrends AbstractCollection
 * which contains a lot of implemented (already!) methods, including contains(), toString() etc.
 * also abstractSet implements Set so out job is... implement two things: iterator() and size()
 * <p>
 * beware:
 * 1. Doesn't check if from >= to
 * 2. Potentially can be overflow if from close to MAXInteger and to is close to MAXone
 * 3. Some methods (contains for example) can work SLOW by default (from box)
 * since they compare values by equals() --- see overriden method which is simply... faster
 */

public class OwnSet {

    static Set<Integer> rangeSet(int fromInclusive, int toExclusive) {

        return new AbstractSet<Integer>() {

            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int next = fromInclusive;

                    @Override
                    public boolean hasNext() {
                        return next != toExclusive;
                    }

                    @Override
                    public Integer next() {
                        if (next == toExclusive) {
                            throw new NoSuchElementException();
                        }
                        return next++;
                    }
                };
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Integer
                        && ((Integer) o) >= fromInclusive
                        && ((Integer) o) < toExclusive;
            }

            @Override
            public int size() {
                return toExclusive - fromInclusive;
            }
        };
    }

    public static void main(String[] args) {
        Set<Integer> integerSet = rangeSet(10, 20);
        System.out.println(integerSet.contains(0));
        System.out.println(integerSet.contains(10));
        System.out.println(integerSet);

        System.out.println(rangeSet(0, Integer.MAX_VALUE).contains(-1));
    }
}
