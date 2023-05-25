package com.acidtango.itxbackend.products.application.useCases;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreator {
    private final ProductRepository productRepository;

    public ProductCreator(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String name, Integer salesUnits) {
        var newProduct = new Product(name, salesUnits);
        return productRepository.create(newProduct);
    }
}
