package ru.job4j.tracker;

import java.util.List;

public class CreateAction implements  UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        List<Item> list = tracker.findAll();
        Item item = new Item(name, list.isEmpty() ? 0 : list.get(list.size() - 1).getId() + 1);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
