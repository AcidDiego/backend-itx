package com.acidtango.itxbackend.products.domain;

import com.acidtango.itxbackend.products.domain.exceptions.VariantNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void fail_on_variant_update_if_not_exists() {
        Product newProduct = new Product("T-SHIRT", 10, List.of());
        String expectedMessage = "Variant not found";

        Exception exception = assertThrows(VariantNotFoundException.class, () -> {
            newProduct.setVariantStock(Size.LARGE, 10);
        });

        assertThat(exception.getMessage()).contains(expectedMessage);
    }

}
