package ru.job4j.opp;

public class DummyDic {
    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        System.out.println(word.engToRus("HELLO"));
    }

    public String engToRus(String eng) {
        return "Неизвестное слово " + eng;
    }
}
