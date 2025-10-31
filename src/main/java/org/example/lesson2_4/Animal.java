package org.example.lesson2_4;

public class Animal {
    private static int animalCount = 0;

    protected final String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract int getMaxRunDistance();
    public abstract int getMaxSwimDistance();

    public void run(int distance) {
        if (distance <= getMaxRunDistance()) {
            System.out.println(name + " пробежал" + distance);
        } else {
            System.out.println(name + " не может пробежать " + distance);
        }
    }

    public void swim(int distance) {
        if (getMaxSwimDistance() == 0) {
            System.out.println(name + " не умеет плавать");
        } else if (distance <= getMaxSwimDistance()) {
            System.out.println(name + " проплыл" + distance);
        } else {
            System.out.println(name + " не может проплыть " + distance);
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }
}