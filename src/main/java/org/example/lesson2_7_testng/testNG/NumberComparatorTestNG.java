package org.example.lesson2_7_testng.testNG;

public class NumberComparatorTestNG {

    @Test
    public void testCompareGreater() {
        assertEquals(NumberComparator.compare(10, 5), "10 больше 5");
        assertTrue(NumberComparator.isGreater(10, 5));
    }

    @Test
    public void testCompareLess() {
        assertEquals(NumberComparator.compare(5, 10), "5 меньше 10");
        assertTrue(NumberComparator.isLess(5, 10));
    }

    @Test
    public void testCompareEqual() {
        assertEquals(NumberComparator.compare(10, 10), "10 равно 10");
        assertTrue(NumberComparator.isEqual(10, 10));
    }

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonData() {
        return new Object[][] {
                {15, 10, "15 больше 10", true, false, false},
                {5, 8, "5 меньше 8", false, true, false},
                {7, 7, "7 равно 7", false, false, true}
        };
    }

    @Test(dataProvider = "comparisonData")
    public void testCompareAllCases(int a, int b, String expectedMessage,
                                    boolean expectedGreater, boolean expectedLess, boolean expectedEqual) {
        assertEquals(NumberComparator.compare(a, b), expectedMessage);
        assertEquals(NumberComparator.isGreater(a, b), expectedGreater);
        assertEquals(NumberComparator.isLess(a, b), expectedLess);
        assertEquals(NumberComparator.isEqual(a, b), expectedEqual);
    }
}
