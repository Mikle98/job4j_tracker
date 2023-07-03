package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String numLeft = left.split("\\.")[0];
        String numRight = right.split("\\.")[0];
        return Integer.compare(Integer.parseInt(numLeft),
                                Integer.parseInt(numRight));
    }
}
