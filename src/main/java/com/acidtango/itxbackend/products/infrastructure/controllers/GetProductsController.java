package com.acidtango.itxbackend.products.infrastructure.controllers;

import com.acidtango.itxbackend.products.application.useCases.ProductLister;
import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductResponseDTO;
import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.ProductResponseListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class GetProductsController {

    private final ProductLister productLister;

    public GetProductsController(final ProductLister productLister) {
        this.productLister = productLister;
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    ProductResponseListDTO getProducts(
            @RequestParam(name = "stockRatioWeight", defaultValue = "1") Integer stockRatioWeight,
            @RequestParam(name = "salesUnitsWeight", defaultValue = "1") Integer salesUnitsWeight
    ) {
        var products = productLister.execute(stockRatioWeight, salesUnitsWeight);
        return ProductResponseListDTO.serialize(products.getItems().stream().map(ProductResponseDTO::serialize).toList());
    }
}
