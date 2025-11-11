package org.example.lesson2_8;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

class PostmanEchoRequestMethodsTests {

    @Test
    void testGetRequest() {
        var response = given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.path("args.foo1")).isEqualTo("bar1");
        assertThat(response.path("args.foo2")).isEqualTo("bar2");
        assertThat(response.path("url")).isEqualTo("https://postman-echo.com/get");
        assertThat(response.path("headers")).isNotNull();
    }

    @Test
    void testPostRequestWithFormParams() {
        var response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "John Doe")
                .formParam("email", "john@example.com")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.path("form.name")).isEqualTo("John Doe");
        assertThat(response.path("form.email")).isEqualTo("john@example.com");
        assertThat(response.path("url")).isEqualTo("https://postman-echo.com/post");
        assertThat(response.path("headers")).isNotNull();
    }

    @Test
    void testPostRequestWithJsonBody() {
        String requestBody = """
            {
                "name": "John Doe",
                "age": 30,
                "city": "New York"
            }
            """;

        var response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.path("json.name")).isEqualTo("John Doe");
        assertThat(response.path("json.age")).isEqualTo(30);
        assertThat(response.path("json.city")).isEqualTo("New York");
        assertThat(response.path("url")).isEqualTo("https://postman-echo.com/post");
    }

    @Test
    void testPutRequest() {
        String requestBody = """
            {
                "id": 123,
                "title": "Updated Title",
                "completed": true
            }
            """;

        var response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.path("json.id")).isEqualTo(123);
        assertThat(response.path("json.title")).isEqualTo("Updated Title");
        assertThat(response.path("json.completed")).isEqualTo(true);
        assertThat(response.path("url")).isEqualTo("https://postman-echo.com/put");
    }

    @Test
    void testPatchRequest() {
        String requestBody = """
            {
                "status": "active",
                "score": 95.5
            }
            """;

        var response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.path("json.status")).isEqualTo("active");
        assertThat(response.path("json.score")).isEqualTo(95.5f);
        assertThat(response.path("url")).isEqualTo("https://postman-echo.com/patch");
    }

    @Test
    void testDeleteRequest() {
        var response = given()
                .param("resourceId", "789")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.statusCode()).isEqualTo(200);

        assertThat(response.path("args.resourceId")).isEqualTo("789");
        assertThat(response.path("url")).isEqualTo("https://postman-echo.com/delete");
        assertThat(response.path("headers")).isNotNull();
    }

    @Test
    void testHeadRequest() {
        given()
                .when()
                .head("/get")
                .then()
                .statusCode(200)
                .header("Content-Type", notNullValue())
                .header("Date", notNullValue());
    }

    @Test
    void testOptionsRequest() {
        given()
                .when()
                .options("/get")
                .then()
                .statusCode(200)
                .header("Access-Control-Allow-Methods", notNullValue());
    }
}
