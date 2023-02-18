package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 1000);
        Book cooking = new Book("Cooking", 350);
        Book animals = new Book("Animals", 700);
        Book abc = new Book("ABC", 26);
        Book[] book = new Book[4];
        book[0] = cleanCode;
        book[1] = cooking;
        book[2] = animals;
        book[3] = abc;
        for (int index = 0; index < book.length; index++) {
            Book bk = book[index];
            System.out.println(bk.getName() + " " + bk.getCountPage());
        }
        book[0] = abc;
        book[3] = cleanCode;
        for (int index = 0; index < book.length; index++) {
            Book bk = book[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " " + bk.getCountPage());
            }
        }
    }
}
