package org.example.lesson2_5;

public class ArrayProcessor {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки, но имеет: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        "Строка " + i + " должна иметь 4 столбца, но имеет: " + array[i].length
                );
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'"
                    );
                }
            }
        }

        return sum;
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("Выход индекса за пределы массива ArrayIndexOutOfBoundsException ");

        int[] numbers = {1, 2, 3, 4, 5};

        try {
            System.out.println("Попытка доступа к элементу с индексом 10...");
            int value = numbers[10];
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Массив имеет длину: " + numbers.length);
            System.out.println("Попытка доступа к индексу: 10");
        }

        try {
            System.out.println("Демонстрация с двумерным массивом...");
            int[][] matrix = {{1, 2}, {3, 4}};
            System.out.println("Попытка доступа к matrix[2][0]...");
            int value = matrix[2][0]; // Выход за границы строк
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException в двумерном массиве!");
            System.out.println("Сообщение: " + e.getMessage());
        }

        try {
            System.out.println("\nДемонстрация с неправильным внутренним индексом...");
            int[][] matrix = {{1, 2}, {3, 4}};
            System.out.println("Попытка доступа к matrix[0][5]...");
            int value = matrix[0][5]; // Выход за границы столбцов
            System.out.println("Значение: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "3", "5", "7"},
                {"2", "4", "6", "8"},
                {"7", "4", "1", "0"},
                {"8", "5", "9", "6"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "3", "5", "7"},
                {"2", "4", "6", "8"},
                {"7", "4", "1", "0"},
                {"8", "5", "abc", "6"}
        };

        System.out.println("=== Тест 1: Корректный массив ===");
        try {
            int result = sumArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Тест 2: Массив неправильного размера ===");
        try {
            int result = sumArray(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        System.out.println("\n=== Тест 3: Массив с некорректными данными ===");
        try {
            int result = sumArray(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }

        demonstrateArrayIndexOutOfBounds();
    }
}