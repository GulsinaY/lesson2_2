package org.example.lesson2_5;

class MyArrayDataException extends MyArrayException {
    private final int row;
    private final int col;
    private final String invalidValue;

    public MyArrayDataException(String message) {
        super(message, "ARRAY_DATA_ERROR");
        this.row = -1;
        this.col = -1;
        this.invalidValue = "unknown";
    }

    public MyArrayDataException(int row, int col, String invalidValue) {
        super(String.format("Неверные данные в ячейке [%d] [%d]: '%s'", row, col, invalidValue), "ARRAY_DATA_ERROR");
        this.row = row;
        this.col = col;
        this.invalidValue = invalidValue;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public String getInvalidValue() { return invalidValue; }

    @Override
    public void printErrorDetails() {
        super.printErrorDetails();
        if (row != -1) {
            System.out.println("Позиция ошибки: [" + row + "][" + col + "]");
            System.out.println("Некорректное значение: " + invalidValue + "'");
        }
    }
}
