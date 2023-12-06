package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder firstString = new StringBuilder();
        for (int i = 0; i < evenElements.size();) {
            firstString.append(evenElements.poll());
            evenElements.poll();
        }
        return firstString.toString();
    }

    private String getDescendingElements() {
        StringBuilder secondString = new StringBuilder();
        for (int i = 0; i < descendingElements.size();) {
            secondString.append(descendingElements.pollLast());
        }
        return secondString.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}