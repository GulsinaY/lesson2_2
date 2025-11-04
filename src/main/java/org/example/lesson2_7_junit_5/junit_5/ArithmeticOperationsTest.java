package org.example.lesson2_7_junit_5.junit_5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Тест сложения")
    void testAdd() {
        assertAll(
                () -> assertEquals(15, ArithmeticOperations.add(10, 5)),
                () -> assertEquals(-5, ArithmeticOperations.add(-10, 5)),
                () -> assertEquals(0, ArithmeticOperations.add(0, 0))
        );
    }

    @Test
    @DisplayName("Тест вычитания")
    void testSubtract() {
        assertAll(
                () -> assertEquals(5, ArithmeticOperations.subtract(10, 5)),
                () -> assertEquals(-15, ArithmeticOperations.subtract(-10, 5)),
                () -> assertEquals(0, ArithmeticOperations.subtract(5, 5))
        );
    }

    @Test
    @DisplayName("Тест умножения")
    void testMultiply() {
        assertAll(
                () -> assertEquals(50, ArithmeticOperations.multiply(10, 5)),
                () -> assertEquals(-50, ArithmeticOperations.multiply(-10, 5)),
                () -> assertEquals(0, ArithmeticOperations.multiply(0, 5))
        );
    }

    @Test
    @DisplayName("Тест деления")
    void testDivide() {
        assertAll(
                () -> assertEquals(2.0, ArithmeticOperations.divide(10, 5), 0.001),
                () -> assertEquals(-2.0, ArithmeticOperations.divide(-10, 5), 0.001),
                () -> assertEquals(2.5, ArithmeticOperations.divide(5, 2), 0.001)
        );
    }

    @Test
    @DisplayName("Деление на ноль должно бросать исключение")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> ArithmeticOperations.divide(10, 0)
        );
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }
}
