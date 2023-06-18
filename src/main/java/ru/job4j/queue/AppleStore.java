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
        String rsl = "";
        for (int i = 0; i < queue.size(); i++) {
            rsl = queue.poll().name();
        }
        return rsl;
    }

    public String getFirstUpsetCustomer(Queue<Customer> customers) {
        String rsl = " ";
        for (int i = 0; i <= queue.size() + 1; i++) {
            rsl = customers.poll().name();
        }
        return rsl;
    }
}
