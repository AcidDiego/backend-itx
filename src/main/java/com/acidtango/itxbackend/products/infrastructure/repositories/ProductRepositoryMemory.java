package com.acidtango.itxbackend.products.infrastructure.repositories;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.ProductRepository;
import com.acidtango.itxbackend.products.domain.Products;
import com.acidtango.itxbackend.products.infrastructure.mappers.ProductMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryMemory implements ProductRepository {

    List<Product> products;

    public ProductRepositoryMemory(final List<Product> products) {
        this.products = products;
    }

    @Override
    public Product create(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        var entity = ProductMapper.MAPPER.fromDomainObject(product);

        return ProductMapper.MAPPER.toDomain(entity);
    }

    @Override
    public Optional<Product> findById(String productId) {
        return products.stream().filter(product -> Objects.equals(product.getProductId(), productId)).findAny();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Products findAll() {
        return new Products(products);
    }
}
