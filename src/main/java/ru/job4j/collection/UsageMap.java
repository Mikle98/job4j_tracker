package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("test@test.test", "Ivan Ivanov");
        hashMap.put("test@test.test", "Petr Ivanov");
        hashMap.put("test2@test.test", "Petr Petrov");
        hashMap.put("test3@test.test", "Mikhail Mikhailov");
        hashMap.put("test@test.test", "Mikhail Ivanov");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}
