package com.acidtango.itxbackend.products.infrastructure.controllers.dtos;

import java.util.List;


public record ProductResponseListDTO(List<ProductResponseDTO> items) {
    public static ProductResponseListDTO serialize(List<ProductResponseDTO> elements) {
        return new ProductResponseListDTO(elements);
    }
}
