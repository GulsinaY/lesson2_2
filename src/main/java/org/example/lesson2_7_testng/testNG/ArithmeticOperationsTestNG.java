package org.example.lesson2_7_testng.testNG;

public class ArithmeticOperationsTestNG {

    @Test
    public void testAdd() {
        assertEquals(ArithmeticOperations.add(10, 5), 15);
        assertEquals(ArithmeticOperations.add(-10, 5), -5);
        assertEquals(ArithmeticOperations.add(0, 0), 0);
    }

    @Test
    public void testSubtract() {
        assertEquals(ArithmeticOperations.subtract(10, 5), 5);
        assertEquals(ArithmeticOperations.subtract(-10, 5), -15);
        assertEquals(ArithmeticOperations.subtract(5, 5), 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(ArithmeticOperations.multiply(10, 5), 50);
        assertEquals(ArithmeticOperations.multiply(-10, 5), -50);
        assertEquals(ArithmeticOperations.multiply(0, 5), 0);
    }

    @Test
    public void testDivide() {
        assertEquals(ArithmeticOperations.divide(10, 5), 2.0);
        assertEquals(ArithmeticOperations.divide(-10, 5), -2.0);
        assertEquals(ArithmeticOperations.divide(1, 2), 0.5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(10, 0);
    }

    @DataProvider(name = "arithmeticData")
    public Object[][] arithmeticData() {
        return new Object[][] {
                {10, 5, 15, 5, 50, 2.0},
                {8, 2, 10, 6, 16, 4.0},
                {0, 5, 5, -5, 0, 0.0}
        };
    }

    @Test(dataProvider = "arithmeticData")
    public void testAllOperations(int a, int b, int expectedSum, int expectedDiff,
                                  int expectedProduct, double expectedQuotient) {
        assertEquals(ArithmeticOperations.add(a, b), expectedSum);
        assertEquals(ArithmeticOperations.subtract(a, b), expectedDiff);
        assertEquals(ArithmeticOperations.multiply(a, b), expectedProduct);
        assertEquals(ArithmeticOperations.divide(a, b), expectedQuotient);
    }
}
