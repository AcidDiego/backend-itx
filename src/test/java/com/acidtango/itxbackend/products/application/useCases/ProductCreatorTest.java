package com.acidtango.itxbackend.products.application.useCases;

import com.acidtango.itxbackend.fixtures.ProductFixtures;
import com.acidtango.itxbackend.products.infrastructure.repositories.ProductRepositoryMemory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductCreatorTest {

    @Test
    void create_a_product() {
        String newProductName = ProductFixtures.COTTON_SHIRT().getName();
        Integer saleUnits = ProductFixtures.COTTON_SHIRT().getSalesUnits();
        ProductRepositoryMemory productRepository = new ProductRepositoryMemory(new ArrayList());
        ProductCreator productCreator = new ProductCreator(productRepository);

        var createdProduct = productCreator.execute(newProductName, saleUnits);

        assertNotNull(createdProduct.getProductId());
        assertEquals(createdProduct.getName(), newProductName);
        assertEquals(createdProduct.getSalesUnits(), saleUnits);
    }


}
