package ru.job4j.collection;

import ru.job4j.search.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.valueOf;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> rsl = new HashSet<>();
        for (Task task : tasks) {
            rsl.add(valueOf(task.getPriority()));
        }
        return rsl;
    }
}
