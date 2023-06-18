package ru.job4j.collection;

import ru.job4j.search.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.valueOf;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> rsl = new HashSet<>();
        int priority;
        for (Task task : tasks) {
            priority = task.getPriority();
            rsl.add(valueOf(priority));
        }
        return rsl;
    }
}
