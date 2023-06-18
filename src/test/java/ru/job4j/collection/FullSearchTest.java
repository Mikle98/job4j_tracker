package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.search.Task;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FullSearchTest {
    @Test
    public void extractNumber() {
        FullSearch fullSearch = new FullSearch();
        List<Task> tasks = Arrays.asList(
                new Task("First desc", 1),
                new Task("Second desc", 2),
                new Task("First desc", 1)
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }
}