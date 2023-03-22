package ru.job4j.opp;

public class HierarchyUsage {
    Car car = new Car();
    Transport tp = car;
    Object obj = car;
    Object ocar = new Car();
    Car carFromObject = (Car) ocar;
    Object bicycle = new Bicycle();
    Car cb = (Car) bicycle;
}
