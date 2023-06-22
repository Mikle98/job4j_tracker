package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        int size = this.evenElements.size();
        for (int i = 0; i < size; i += 2) {
            rsl.append(this.evenElements.poll());
            this.evenElements.poll();
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        int size = this.descendingElements.size();
        for (int i = 0; i < size; i++) {
            rsl.append(this.descendingElements.pollLast());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
