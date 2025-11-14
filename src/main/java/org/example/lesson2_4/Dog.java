package org.example.lesson2_4;

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public int getMaxRunDistance() {
        return 500;
    }

    @Override
    public int getMaxSwimDistance() {
        return 10;
    }

    public static int getDogCount() {
        return dogCount;
    }
}