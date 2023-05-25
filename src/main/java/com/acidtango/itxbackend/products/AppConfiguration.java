package com.acidtango.itxbackend.products;

import com.acidtango.itxbackend.products.domain.ProductRepository;
import com.acidtango.itxbackend.products.infrastructure.repositories.ProductRepositoryMongo;
import com.acidtango.itxbackend.products.infrastructure.repositories.ProductRepositoryInternal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {
    @Bean
    @Primary
    public ProductRepository createProductRepository(ProductRepositoryInternal productRepositoryMongo) {
        return new ProductRepositoryMongo(productRepositoryMongo);
    }
}
