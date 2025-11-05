package org.example.lesson2_8;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class PostmanEchoBaseTest {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";

        // Опционально: логирование запросов и ответов
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
