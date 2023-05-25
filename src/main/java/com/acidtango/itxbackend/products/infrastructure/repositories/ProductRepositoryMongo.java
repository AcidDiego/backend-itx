package com.acidtango.itxbackend.products.infrastructure.repositories;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.ProductRepository;
import com.acidtango.itxbackend.products.domain.Products;
import com.acidtango.itxbackend.products.infrastructure.entities.ProductEntity;

import java.util.ArrayList;
import java.util.Optional;

public class ProductRepositoryMongo implements ProductRepository {
    private final ProductRepositoryInternal productRepository;


    public ProductRepositoryMongo(ProductRepositoryInternal productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        var newProduct = productRepository.save(ProductEntity.fromDomain(product));
        return newProduct.toDomain();
    }

    public Optional<Product> findById(String productId) {
        var productEntity = productRepository.findById(productId);
        return productEntity.map(ProductEntity::toDomain);
    }


    public void save(Product product) {
        var newProductEntity = ProductEntity.fromDomain(product);
        productRepository.save(newProductEntity);
    }

    public Products findAll() {
        var foundProducts = new ArrayList();
        productRepository.findAll().forEach(productEntity -> foundProducts.add(productEntity.toDomain()));
        return new Products(foundProducts);
    }
}
