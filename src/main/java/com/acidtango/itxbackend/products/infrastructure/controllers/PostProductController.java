package com.acidtango.itxbackend.products.infrastructure.controllers;

import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductCreationDTO;
import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductResponseDTO;
import com.acidtango.itxbackend.products.application.useCases.ProductCreator;
import com.acidtango.itxbackend.products.infrastructure.mappers.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostProductController {

    private final ProductCreator productCreation;

    public PostProductController(final ProductCreator productCreation) {
        this.productCreation = productCreation;
    }


    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDTO newProduct(@RequestBody ProductCreationDTO newProduct) {
        var result = productCreation.execute(newProduct.getName(), newProduct.getSalesUnits());
        return ProductMapper.MAPPER.toProductResponseDTO(result);
    }
}
