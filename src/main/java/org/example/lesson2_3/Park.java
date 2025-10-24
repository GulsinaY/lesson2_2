package org.example.lesson2_3;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("Аттракцион: %s, Время работы: %s, Стоимость: %.2f руб.",
                    name, workingHours, price);
        }
    }

    public void addAttraction(String name, String workingHours, double price) {
        Attraction attraction = new Attraction(name, workingHours, price);
        attractions.add(attraction);
    }

    public void displayAttractions() {
        System.out.println("Парк: " + name);
        System.out.println("Аттракционы:");
        for (Attraction attraction : attractions) {
            System.out.println("  - " + attraction);
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    @Override
    public String toString() {
        return "Парк: " + name + " (аттракционов: " + attractions.size() + ")";
    }

    public static void main(String[] args) {

        Park kashkadan = new Park("Кашкадан");
        Park garipova = new Park("Гарипова");
        Park neftyanikov = new Park("Нефтяников");

        kashkadan.addAttraction("катер", "10:00-20:00", 150.0);
        kashkadan.addAttraction("катамаран", "09:00-19:00", 200.0);
        kashkadan.addAttraction("горка", "11:00-21:00", 100.0);

        garipova.addAttraction("поезд", "10:00-18:00", 80.0);
        garipova.addAttraction("батут", "09:00-20:00", 50.0);
        garipova.addAttraction("карусель", "10:00-19:00", 70.0);

        neftyanikov.addAttraction("канаты", "10:00-22:00", 120.0);
        neftyanikov.addAttraction("тир", "11:00-23:00", 40.0);
        neftyanikov.addAttraction("карусель", "10:00-20:00", 90.0);

        kashkadan.displayAttractions();
        garipova.displayAttractions();
        neftyanikov.displayAttractions();
    }
}
