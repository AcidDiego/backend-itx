package com.acidtango.itxbackend.products.domain.services;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.ProductRepository;
import com.acidtango.itxbackend.products.domain.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ProductFinder {
    private final ProductRepository productRepository;


    public ProductFinder(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findByIdOrThrow(final String productId) {
        var product = productRepository.findById(productId);
        return product.orElseThrow(() -> new ProductNotFoundException(productId));
    }
}