package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Petr");
        name.add("Ivan");
        name.add("Stepan");
        for (String str : name) {
            System.out.println(str);
        }
    }
}
