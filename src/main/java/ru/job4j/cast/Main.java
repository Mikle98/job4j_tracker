package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle airplan = new Airplan();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{airplan, bus, train};
        for (Vehicle i: vehicles) {
            i.move();
            i.speed();
        }
    }
}
