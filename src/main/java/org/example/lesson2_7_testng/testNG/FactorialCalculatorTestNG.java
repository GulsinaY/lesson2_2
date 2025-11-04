package org.example.lesson2_7_testng.testNG;

public class FactorialCalculatorTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {2, 2},
                {3, 6},
                {4, 24},
                {6, 720},
                {10, 3628800}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorials(int input, long expected) {
        assertEquals(FactorialCalculator.calculateFactorial(input), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-1);
    }
}
