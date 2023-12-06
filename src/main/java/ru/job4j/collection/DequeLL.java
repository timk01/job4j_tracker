package ru.job4j.collection;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeLL {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");
        for (String string : deque) {
            System.out.println(string);
        }

        System.out.println();
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);

        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");

        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        Iterator<String> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
    }
}
