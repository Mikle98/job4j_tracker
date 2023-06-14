package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private static final String STR = "Количество двигателей равно: ";

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println(("A380").equals(this.name) ? STR + 4 : STR + COUNT_ENGINE);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
