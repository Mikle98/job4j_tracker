package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ходит по дорогам");
    }

    @Override
    public void speed() {
        System.out.println("Скорость ~ 90 км/ч");
    }
}
