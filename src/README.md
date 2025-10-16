public class Main {

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
       public static void main(String[] args) {
               printThreeWords();
    }//1

    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        
        int sum = a + b;
        
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }//2

    public static void printColor() {
        int value = 69;
        
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }//3
    
    public static void main(String[] args) {
        printColor();

    public static void compareNumbers() {
        int a = 15;
        int b = 10;
        
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }//4
    
    public static void main(String[] args) {
        compareNumbers();

}

public static boolean isSumInRange(int num1, int num2) {
    int sum = num1 + num2;
    if (sum >= 10 && sum <= 20) {
        return true;
    } else {
        return false;
    }
}//5

public class NumberChecker {
    public static void main(String[] args) {
        checkNumber(1);
        checkNumber(0);
        checkNumber(-1);
    }

    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }
}//6

public class Main {
    public static void main(String[] args) {
        System.out.println(isNegative(-5));  // true
        System.out.println(isNegative(0));   // false
        System.out.println(isNegative(5));  // false
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }
}//7

public class Main {
    public static void main(String[] args) {
    printStringMultipleTimes("Ура!", 3);
    }

    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
}//8

public static boolean isLeapYear(int year) {
    if (year % 400 == 0) {
        return true;
    } else if (year % 100 == 0) {
        return false;
    } else {
        return year % 4 == 0;
    }
}//9

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.print("Первоначальный массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        
        System.out.print("Массив после: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}//10

public class ArrayExample {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
                for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}//11

public class ArrayMultiplier {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Первоначальный массив: ");
        printArray(array);
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        
        System.out.println("Массив после: ");
        printArray(array);
    }
}//12

public class Main {
    public static void main(String[] args) {
        int size = 5;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}//13

public class Main {

    static int[] makeArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = value;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(makeArray(3, 7)));
    }
}//14