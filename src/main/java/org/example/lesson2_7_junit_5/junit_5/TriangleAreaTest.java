package org.example.lesson2_7_junit_5.junit_5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {
    @Test
    @DisplayName("Площадь треугольника по основанию и высоте")
    void testCalculateAreaWithBaseAndHeight() {
        assertAll(
                () -> assertEquals(10.0, TriangleArea.calculateArea(5, 4), 0.001),
                () -> assertEquals(25.0, TriangleArea.calculateArea(10, 5), 0.001)
        );
    }

    @Test
    @DisplayName("Неверные входные данные для площади треугольника")
    void testCalculateAreaWithInvalidInput() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> TriangleArea.calculateArea(-5, 4)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> TriangleArea.calculateArea(5, -4))
        );
    }

    @Test
    @DisplayName("Площадь треугольника по формуле Герона")
    void testCalculateAreaHeron() {
        assertAll(
                () -> assertEquals(6.0, TriangleArea.calculateAreaHeron(3, 4, 5), 0.001),
                () -> assertEquals(14.6969, TriangleArea.calculateAreaHeron(5, 6, 7), 0.001)
        );
    }

    @Test
    @DisplayName("Несуществующий треугольник должен бросать исключение")
    void testCalculateAreaHeronWithInvalidTriangle() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.calculateAreaHeron(1, 1, 3));
    }
}