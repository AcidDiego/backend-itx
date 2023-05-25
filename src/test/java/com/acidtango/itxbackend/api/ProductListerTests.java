package com.acidtango.itxbackend.api;

import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductResponseListDTO;
import com.acidtango.itxbackend.fixtures.InitialData;
import com.acidtango.itxbackend.products.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductListerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ProductRepository repository;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        mongoTemplate.getCollection("products").drop();
        InitialData.INITIAL_DATA.forEach(product -> {
            repository.create(product);
        });
    }

    @Test
    void list_all_products_on_test() {
        ProductResponseListDTO products = given()
                .port(port)
                .get("/products").as(ProductResponseListDTO.class);

        assertThat(products.items()).hasSize(6);
    }

    @Test
    void list_sort_products_by_stock() {
        String maxStockId = "5";
        ProductResponseListDTO products = given()
                .port(port)
                .queryParam("stockRatioWeight", 0)
                .queryParam("salesUnitsWeight", 1)
                .get("/products").as(ProductResponseListDTO.class);

        assertThat(products.items()).hasSize(6);
        assertThat(products.items().get(0).getId()).isEqualTo(maxStockId);
    }

    @Test
    void list_sort_products_by_sales() {
        String maxSalesId = "4";
        ProductResponseListDTO products = given()
                .port(port)
                .queryParam("stockRatioWeight", 1)
                .queryParam("salesUnitsWeight", 0)
                .get("/products").as(ProductResponseListDTO.class);

        assertThat(products.items()).hasSize(6);
        assertThat(products.items().get(0).getId()).isEqualTo(maxSalesId);
    }
}
