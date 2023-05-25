package com.acidtango.itxbackend.products.infrastructure.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseListDTO {
    public List<ProductResponseDTO> items;

    public static ProductResponseListDTO serialize(List<ProductResponseDTO> elements) {
        return new ProductResponseListDTO(elements);
    }
}
