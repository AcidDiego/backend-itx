package com.acidtango.itxbackend.products.infrastructure.repositories;


import com.acidtango.itxbackend.products.infrastructure.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositoryInternal extends MongoRepository<ProductEntity, String> {
}
