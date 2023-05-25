package com.acidtango.itxbackend.products.infrastructure.controllers;

import com.acidtango.itxbackend.products.infrastructure.controllers.dtos.VariantCreationDTO;
import com.acidtango.itxbackend.products.application.useCases.VariantCreator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostVariantController {

    private final VariantCreator variantCreation;

    public PostVariantController(final VariantCreator variantCreation) {
        this.variantCreation = variantCreation;
    }


    @PostMapping("/products/{productId}/variants")
    void newVariant(@PathVariable String productId, @RequestBody VariantCreationDTO newVariant) {
        variantCreation.execute(productId, newVariant.getSize(), newVariant.getStock());
    }
}
