package org.example.lesson2_5;

abstract class MyArrayException extends Exception {
    private final String errorCode;

    public MyArrayException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void printErrorDetails() {
        System.out.println("Код ошибки: " + errorCode);
        System.out.println("Сообщение: " + getMessage());
    }
}
