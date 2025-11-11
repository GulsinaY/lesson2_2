package org.example.lesson2_3;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, LocalDate productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Свободен"));
    }
}

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(
                "Кровать",
                LocalDate.of(2025, 10, 24),
                "ИП Иванов И.И.",
                "Россия",
                12000.00,
                true
        );
        Product product2 = new Product(
                "Стул",
                LocalDate.of(2025, 6, 14),
                "ООО Денеб",
                "Россия",
                4500.00,
                false
        );
        Product product3 = new Product(
                "Диван",
                LocalDate.of(2025, 9, 1),
                "ООО Вита",
                "Россия",
                65500.00,
                false
        );

        product1.printInfo();
        product2.printInfo();
        product3.printInfo();
    }
public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", LocalDate.of(2025, 4, 8), "Samsung Corp.", "Korea", 5599.00, true);
        productsArray[1] = new Product("Холодильник", LocalDate.of(2025, 5, 7), "Аристон", "Китай", 37999.00, false);
        productsArray[2] = new Product("Телевизор", LocalDate.of(2025, 10, 3), "LG", "Вьетнам", 23780.00, true);
        productsArray[3] = new Product("Стиральная машина", LocalDate.of(2025, 5, 3), "Bosch", "Германия", 76980.00, false);
        productsArray[4] = new Product("Пылесос", LocalDate.of(2025, 3, 3), "Polaris", "Беларусь", 32679.00, false);

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар " + (i + 1) + productsArray[i].name);
        }
    }
}
