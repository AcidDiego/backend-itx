package com.acidtango.itxbackend.products.application.useCases;

import com.acidtango.itxbackend.fixtures.ProductFixtures;
import com.acidtango.itxbackend.fixtures.VariantFixture;
import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.Variant;
import com.acidtango.itxbackend.products.domain.services.ProductFinder;
import com.acidtango.itxbackend.products.infrastructure.repositories.ProductRepositoryMemory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VariantCreatorTest {

    @Test
    void create_a_product_variant() {
        Product savedProduct = ProductFixtures.SHIRT_WITHOUT_VARIANT();
        Variant newVariant = VariantFixture.SMALL_VARIANT();
        ProductRepositoryMemory productRepository = new ProductRepositoryMemory(List.of(savedProduct));
        VariantCreator variantCreator = new VariantCreator(new ProductFinder(productRepository), productRepository);

        variantCreator.execute(savedProduct.getProductId(), newVariant.getSize(), newVariant.getStock());

        assertEquals(savedProduct.getVariants().size(), 1);
        assertEquals(savedProduct.getVariants().get(0).getSize(), newVariant.getSize());
    }


}
