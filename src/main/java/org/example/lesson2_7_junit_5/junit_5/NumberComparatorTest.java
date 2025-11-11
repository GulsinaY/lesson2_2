package org.example.lesson2_7_junit_5.junit_5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    @Test
    @DisplayName("Сравнение чисел: больше")
    void testCompareGreater() {
        assertEquals("10 больше 5", NumberComparator.compare(10, 5));
    }

    @Test
    @DisplayName("Сравнение чисел: меньше")
    void testCompareLess() {
        assertEquals("5 меньше 10", NumberComparator.compare(5, 10));
    }

    @Test
    @DisplayName("Сравнение чисел: равны")
    void testCompareEqual() {
        assertEquals("Числа равны", NumberComparator.compare(5, 5));
    }

    @Test
    @DisplayName("Проверка равенства чисел")
    void testIsEqual() {
        assertAll(
                () -> assertTrue(NumberComparator.isEqual(5, 5)),
                () -> assertFalse(NumberComparator.isEqual(5, 10))
        );
    }

    @Test
    @DisplayName("Проверка 'больше'")
    void testIsGreater() {
        assertAll(
                () -> assertTrue(NumberComparator.isGreater(10, 5)),
                () -> assertFalse(NumberComparator.isGreater(5, 10))
        );
    }

    @Test
    @DisplayName("Проверка 'меньше'")
    void testIsLess() {
        assertAll(
                () -> assertTrue(NumberComparator.isLess(5, 10)),
                () -> assertFalse(NumberComparator.isLess(10, 5))
        );
    }
}
