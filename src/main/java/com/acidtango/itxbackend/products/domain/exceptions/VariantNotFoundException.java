package com.acidtango.itxbackend.products.domain.exceptions;

import com.acidtango.itxbackend.products.domain.Size;

public class VariantNotFoundException extends RuntimeException {
    public VariantNotFoundException(final Size size) {
        super(String.format("Variant not found with size: %s", size.toString()));
    }
}
