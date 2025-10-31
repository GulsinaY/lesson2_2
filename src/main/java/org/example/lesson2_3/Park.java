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
}
