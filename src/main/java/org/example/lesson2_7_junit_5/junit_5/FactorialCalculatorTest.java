package org.example.lesson2_7_junit_5.junit_5;

import org.example.lesson2_7_junit_5.FactorialCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    @DisplayName("Факториал 0 должен быть равен 1")
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    @DisplayName("Факториал 1 должен быть равен 1")
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    @DisplayName("Факториал положительных чисел")
    void testFactorialOfPositiveNumber() {
        assertAll(
                () -> assertEquals(120, FactorialCalculator.factorial(5)),
                () -> assertEquals(3628800, FactorialCalculator.factorial(10))
        );
    }

    @Test
    @DisplayName("Факториал отрицательного числа должен бросать исключение")
    void testFactorialOfNegativeNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> FactorialCalculator.factorial(-5)
        );
        assertEquals("Факториал отрицательного числа не определен", exception.getMessage());
    }
}
