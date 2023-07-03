package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = left.length() > right.length() ? left.length() : right.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (right.length() <= i) {
                count += (int) left.charAt(i) - 96;
            } else if (left.length() <= i) {
                count -= (int) right.charAt(i) - 96;
            } else {
                count += Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return count;
    }
}
