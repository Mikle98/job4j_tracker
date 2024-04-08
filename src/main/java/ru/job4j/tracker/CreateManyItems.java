package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        out.println("Добавлено заявок: " + count);
        return true;
    }

    public static void main(String[] args) throws SQLException {
        ConsoleInput consoleInput = new ConsoleInput();
        MemTracker memTracker = new MemTracker();
        CreateManyItems createManyItems = new CreateManyItems(System.out::println);
        while (true) {
            createManyItems.execute(consoleInput, memTracker);
            DeleteAllItems deleteAllItems = new DeleteAllItems(System.out::println);
            deleteAllItems.execute(consoleInput, memTracker);
        }
    }
}
