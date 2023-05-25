package com.acidtango.itxbackend.api;

import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductCreationDTO;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.given;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductCreationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MongoTemplate mongoTemplate;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {

        mongoTemplate.getCollection("products").drop();

    }

    @Test
    void creates_a_product() {
        var expectedProductName = "New Shirt";
        var salesUnits = 1;

        given()
                .port(port)
                .body(new ProductCreationDTO(expectedProductName, salesUnits))
                .contentType(ContentType.JSON)
                .post("/products")
                .then()
                .assertThat()
                .body("id", response -> Matchers.notNullValue())
                .statusCode(HttpStatus.CREATED.value());
    }
}
