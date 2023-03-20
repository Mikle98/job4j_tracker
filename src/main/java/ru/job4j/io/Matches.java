package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 3 || matches < 1) {
                System.out.println("Число должно быть в в пределах от 1 до 3 (включительно)" + System.lineSeparator()
                                    + "Введите корректное число еще раз");
            } else if (count < matches) {
                System.out.println("Невозможно отнять больше спичек, чем осталось" + System.lineSeparator()
                                    + "Введите корректное число еще раз");
            } else {
                turn = !turn;
                count -= matches;
                System.out.println("Спичек осталось на столе " + count);
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
