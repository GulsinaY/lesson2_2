package org.example.lesson2_7;

public class NumberComparator {
    public static String compare(int a, int b) {
        return switch (Integer.compare(a, b)) {
            case 1 -> a + " больше " + b;
            case -1 -> a + " меньше " + b;
            default -> "Числа равны";
        };
    }

    public static boolean isEqual(int a, int b) {
        return a == b;
    }

    public static boolean isGreater(int a, int b) {
        return a > b;
    }

    public static boolean isLess(int a, int b) {
        return a < b;
    }
}
