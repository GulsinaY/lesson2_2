package org.example.lesson2_4;

public class GeometryCalculator {
    public static void main(String[] args) {
        System.out.println();

        GeometricShape circle = new Circle(5, "Синий", "Серый");
        GeometricShape rectange = new Rectange(7, 3, "Белый", "Чёрный");
        GeometricShape triangle = new Triangle(3, 4, 5, "Серый", "Красный");

        System.out.println("Круг: ");
        circle.printInfo();

        System.out.println("Прямоугольник: ");
        rectange.printInfo();

        System.out.println("Треугольник: ");
        triangle.printInfo();
    }
}
