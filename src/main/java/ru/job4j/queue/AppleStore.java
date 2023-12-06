package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastHappyCustomer = null;
        for (int i = 0; i < count; i++) {
            if (queue.isEmpty()) {
                break;
            }
            lastHappyCustomer = queue.poll();
        }
        return lastHappyCustomer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer lastUpsetCustomer = null;
        if (count > queue.size()) {
            return null;
        }
        for (int i = 0; i <= count; i++) {
            lastUpsetCustomer = queue.poll();
        }
        return lastUpsetCustomer.name();
    }
}