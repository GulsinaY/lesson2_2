package org.example.lesson2_7_testng.testNG;

public class TriangleAreaTestNG {

    @Test
    public void testCalculateArea() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
        assertEquals(TriangleArea.calculateArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithZeroBase() {
        TriangleArea.calculateArea(0, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaWithNegativeHeight() {
        TriangleArea.calculateArea(5, -1);
    }

    @DataProvider(name = "heronData")
    public Object[][] heronData() {
        return new Object[][] {
                {3, 4, 5, 6.0},
                {5, 5, 6, 12.0},
                {6, 8, 10, 24.0}
        };
    }

    @Test(dataProvider = "heronData")
    public void testCalculateAreaHeron(double a, double b, double c, double expected) {
        double result = TriangleArea.calculateAreaHeron(a, b, c);
        assertEquals(result, expected, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaHeronWithInvalidTriangle() {
        TriangleArea.calculateAreaHeron(1, 1, 3);
    }
}
