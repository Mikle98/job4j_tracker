package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void ride() {
        System.out.println("Ездит медлено");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Вмещает в себя " + count + " пассажиров");
    }

    @Override
    public float refuel(float fuel) {
        return fuel * 0.68F;
    }
}
