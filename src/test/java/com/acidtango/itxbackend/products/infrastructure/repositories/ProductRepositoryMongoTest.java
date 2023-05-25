package com.acidtango.itxbackend.products.infrastructure.repositories;

import com.acidtango.itxbackend.fixtures.ProductFixtures;
import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataMongoTest
public class ProductRepositoryMongoTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProductRepositoryInternal productRepositoryInternal;

    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        mongoTemplate.getCollection("products").drop();
        productRepository = new ProductRepositoryMongo(productRepositoryInternal);

    }

    @Test
    void create_product() {
        Product newProduct = new Product("T-SHIRT", 10, List.of());

        var result = productRepository.create(newProduct);

        assertThat(result.getProductId()).isNotNull();
        assertThat(newProduct.getProductId()).isNull();
        assertThat(result.getName()).isEqualTo(newProduct.getName());
    }

    @Test
    void find_by_id() {
        String id = "saved-id";
        Product newProduct = new Product(id, "T-SHIRT", 10, List.of());
        productRepository.create(newProduct);

        var result = productRepository.findById(id);

        assertThat(result.get().getProductId()).isEqualTo(id);
        assertThat(result.get().getName()).isEqualTo(newProduct.getName());
    }

    @Test
    void find_all() {
        Product newProduct = ProductFixtures.COTTON_SHIRT();
        Product newProduct2 = ProductFixtures.FIT_SHIRT();
        productRepository.create(newProduct);
        productRepository.create(newProduct2);

        var result = productRepository.findAll();

        assertThat(result.getItems()).hasSize(2);
    }

}
