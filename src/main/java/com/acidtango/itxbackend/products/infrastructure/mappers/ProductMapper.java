package com.acidtango.itxbackend.products.infrastructure.mappers;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductResponseDTO;
import com.acidtango.itxbackend.products.infrastructure.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductEntity fromDomainObject(Product product);

    Product toDomain(ProductEntity productEntity);

    @Mapping(source = "productId", target = "id")
    ProductResponseDTO toProductResponseDTO(Product product);

}
