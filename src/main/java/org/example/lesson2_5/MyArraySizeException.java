package org.example.lesson2_5;

class MyArraySizeException extends MyArrayException {
    public MyArraySizeException(String message) {
        super(message, "ARRAY_SIZE_ERROR");
    }
    public MyArraySizeException(int expectedRows, int actualRows, int expectedCols, int actualCols) {
        super(String.format("Неверный размер массива. Ожидалось: %dx%d, получено: %dx%d", expectedRows, expectedCols, actualRows, actualCols), "ARRAY_SIZE_ERROR");
    }
}
