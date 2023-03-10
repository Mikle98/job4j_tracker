package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getDateTime());
        System.out.println(item.getDateTime().format(formatter));
        Item item1 = new Item("Test", 1);
        System.out.println(item1);
    }
}
