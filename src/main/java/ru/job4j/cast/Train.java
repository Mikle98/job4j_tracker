package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ходит по рельсам");
    }

    @Override
    public void speed() {
        System.out.println("Скорость ~ 120 км/ч");
    }
}
