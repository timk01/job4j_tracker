package ru.job4j.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");

        for (String string : queue) {
            System.out.println(string);
        }

        queue.remove();
        System.out.println();
        System.out.println("State of Queue after remove: ");
        for (String string : queue) {
            System.out.println(string);
        }
        queue.remove();
        queue.remove();
        System.out.println(queue.poll());

        System.out.println();
        Queue<String> queue2 = new ArrayBlockingQueue<>(3);
        queue2.offer("first");
        queue2.offer("second");
        queue2.offer("third");
        queue2.offer("fourth");

        for (String string : queue2) {
            System.out.println(string);
        }

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());

    }
}