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

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0);
    }

    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amound) {
        if (amound > 0) {
            foodAmount += amound;
            System.out.println("В миску добавлено " + amound + " еды. Теперь в миске: " + " еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    @Override
    public int getMaxRunDistance() {
        return 200;
    }

    @Override
    public int getMaxSwimDistance() {
        return 0;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (foodAmount <= 0) {
            System.out.println(name + ": количество еды должно быть положительным");
            return;
        }
        if (bowl.decreaseFood(foodAmount)) {
            isFull = true;
            System.out.println(name + "поел" + foodAmount + " еды и теперь сыт");
        } else {
            System.out.println(name + ": в миске недостаточно еды. Необходимо: " + foodAmount + " Доступно: " + bowl.getFoodAmount());
        }
    }

    public void eat(Bowl bowl) {
        eat(bowl, 10);
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}

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
                new Cat("Персик");
                new Cat("Том");
                new Cat("Пушок");
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

class Circle implements GeometricShape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectange implements GeometricShape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectange(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements GeometricShape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

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