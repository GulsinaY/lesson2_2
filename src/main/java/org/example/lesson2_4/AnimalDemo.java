package org.example.lesson2_4;

public class AnimalDemo {
    public static void main(String[] args) {
        System.out.println();
        Cat cat1 = new Cat("Варя");
        Cat cat2 = new Cat("Пират");
        Dog dog1 = new Dog("Лорд");
        Dog dog2 = new Dog("Люси");

        cat1.run(150);
        cat1.run(250);
        cat1.swim(5);
        dog1.run(400);
        dog1.run(600);
        dog1.swim(15);

        System.out.println();

        Bowl bowl = new Bowl(25);

        Cat[] cats = {
                new Cat("Персик"),
        new Cat("Том"),
        new Cat("Пушок"),
        };

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("Кормление котов");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "покушал" : "голоден"));
        }
        System.out.println("Добавить еды");
        bowl.addFood(30);

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl);
            }
        }
    }
}