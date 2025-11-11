package org.example.lesson2_4;

interface GeometricShape {
    double calculateArea();
    String getFillCollor();
    String getBorderColor();

    default double calculatePerimeter() {
        return 0.0;
    }

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + getFillCollor());
        System.out.println("Цвет границ: " + getBorderColor());
    }
}