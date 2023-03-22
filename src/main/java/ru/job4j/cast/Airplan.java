package ru.job4j.cast;

public class Airplan implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летает по воздуху");
    }

    @Override
    public void speed() {
        System.out.println("Скорость ~ 300 км/ч");
    }
}
