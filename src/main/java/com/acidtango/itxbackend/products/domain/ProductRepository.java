package com.acidtango.itxbackend.products.domain;

import java.util.Optional;

public interface ProductRepository {

    Product create(final Product product);

    Optional<Product> findById(String productId);

    void save(final Product product);

    Products findAll();
}
