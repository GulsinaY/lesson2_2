package org.example.lesson2_7_testng;

public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        return switch (n) {
            case 0, 1 -> 1;
            default -> {
                long result = 1;
                for (int i = 2; i <= n; i++) {
                    result *= i;
                }
                yield result;
            }
        };
    }
}
