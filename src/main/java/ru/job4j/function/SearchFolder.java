package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        Function<List<Folder>, List<Folder>> fun = list1 -> {
            List<Folder> rsl = new ArrayList<>();
            for (Folder f : list1) {
                if (pred.test(f)) {
                    rsl.add(f);
                }
            }
            return rsl;
        };
        return fun.apply(list);
    }
}
