package com.acidtango.itxbackend.products.infrastructure.controllers.dtos;

import lombok.Value;

import java.util.List;

@Value
public class ProductResponseListDTO {
    final List<ProductResponseDTO> items;

    public static ProductResponseListDTO serialize(List<ProductResponseDTO> elements) {
        return new ProductResponseListDTO(elements);
    }
}
