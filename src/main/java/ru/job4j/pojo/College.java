package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("NagovitsinMS");
        student.setGroup("Trainee");
        student.setStartDate(new Date());
        System.out.println("Name: " + student.getFio() + System.lineSeparator()
                            + "Group: " + student.getGroup() + System.lineSeparator()
                            + "Start Date: " + student.getStartDate());
    }
}
