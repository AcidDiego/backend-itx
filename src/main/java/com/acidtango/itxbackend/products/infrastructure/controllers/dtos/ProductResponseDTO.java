package com.acidtango.itxbackend.products.infrastructure.controllers.dtos;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.Variant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductResponseDTO {
    private String id;
    private String name;
    private List<Variant> variants;


    public static ProductResponseDTO serialize(Product product) {
        return new ProductResponseDTO(product.getProductId(), product.getName(), product.getVariants());
    }

};



