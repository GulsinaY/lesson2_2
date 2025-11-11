package org.example.lesson2_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> entries;
    public PhoneDirectory() {
        this.entries = new HashMap<>();
    }
    public void add(String lastName, String phoneNumber) {
        entries.putIfAbsent(lastName, new ArrayList<>());
        entries.get(lastName).add(phoneNumber);
    }//Добавить запись
    public List<String> get(String lastName) {
        return entries.getOrDefault(lastName, new ArrayList<>());
    }//Поиск по фамилии
    public boolean contains(String lastName) {
        return entries.containsKey(lastName);
    }
    public int size() {
        return entries.size();
    }//Ответ
    public void printAll() {
        System.out.println();
        for (Map.Entry<String, List<String>> entry : entries.entrySet()) {
            System.out.println(entry.getKey() + " " + String.join(", ", entry.getValue()));
        }
    }
}
