package com.acidtango.itxbackend.products.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(final String productId) {
        super(String.format("Product Not Found with id: %s", productId));
    }
}
