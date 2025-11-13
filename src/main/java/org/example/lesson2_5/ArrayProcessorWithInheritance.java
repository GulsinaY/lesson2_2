package org.example.lesson2_5;

public class ArrayProcessorWithInheritance {

    private static final int EXPECTED_ROWS = 4;
    private static final int EXPECTED_COLS = 4;
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        validateArraySize(array);
        return calculateSum(array);
    }

    private static void validateArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != EXPECTED_ROWS) {
            throw new MyArraySizeException(EXPECTED_ROWS, array.length, EXPECTED_COLS, EXPECTED_COLS);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != EXPECTED_COLS) {
                throw new MyArraySizeException(EXPECTED_ROWS, array.length, EXPECTED_COLS, array[i].length);
            }
        }
    }

    private static int calculateSum(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += parseAndValidateCell(array[i][j], i, j);
            }
        }
        return sum;
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n Демонстрация ArrayIndexOutOfBoundsException");
        int[] numbers = {1, 2, 3};
        try {
            System.out.println("Поймано ArrayIndexOutOfBoundsException");
            System.out.println("Это RuntimeException: " + (e instanceof RuntimeException));
            System.out.println("Сообщение: " + e.getMessage());
            printExceptionHierarchy(e);
        }
    }

    private static void printExceptionHierarchy(Exception e) {
        System.out.println("Иерархия наследования: ");
        Class<?> clazz = e.getClass();
        while (clazz != null) {
            System.out.println( clazz.getSimpleName());
            clazz = clazz.getSuperclass();
        }
    }

    private static void handleExceptionUsingParent(MyArrayException e) {
        System.out.println("\n Обработка через родительский класс");
        e.printErrorDetails();

        if (e instanceof MyArraySizeException) {
            System.out.println("Проверьте размер массива");
        } else if (e instanceof MyArrayDataException arrayDataException) {
            System.out.println("Проверьте данные в указанной ячейке");
        }
    }

    public static void main(String[] args) {
        System.out.println("Тест 1: Корректный массив");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(correctArray);
        } catch (MyArrayException e) {
            handleExceptionUsingParent(e);
        }

        System.out.println("Тест 2: Массив неправильного размера");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            handleExceptionUsingParent(e);
        } catch (MyArrayDataException e) {
            handleExceptionUsingParent(e);
        }

        System.out.println("\n Тест 3: Массив с некорректными данными");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArrayException e) {
            handleExceptionUsingParent(e);
        }

        for (MyArrayException exception : exception) {
            System.out.println("\n Обработка исключения типа: " + exception.getClass().getSimpleName());
            handleExceptionUsingParent(exception);
        }

        demonstrateArrayIndexOutOfBounds();

        System.out.println("\n Общая обработка");
        String[][] testArray = {
                {"1", "2", "abc", "4"},
                {"5", "6", "7"}
        };

        try {
            int result = processArray(testArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArrayException e) {
            System.out.println("Общая обработка исключений: ");
            System.out.println("Тип исключения: " + e.getClass().getSimpleName());
            System.out.println("Код ошибки: " + e.getErrorCode());
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}
