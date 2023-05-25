package com.acidtango.itxbackend.products.application.useCases;

import com.acidtango.itxbackend.products.domain.ProductRepository;
import com.acidtango.itxbackend.products.domain.Size;
import com.acidtango.itxbackend.products.domain.Variant;
import com.acidtango.itxbackend.products.domain.services.ProductFinder;
import org.springframework.stereotype.Component;

@Component

public class VariantCreator {

    private final ProductFinder productFinder;
    private final ProductRepository productRepository;

    public VariantCreator(final ProductFinder productFinder, final ProductRepository productRepository) {
        this.productFinder = productFinder;
        this.productRepository = productRepository;
    }

    public void execute(final String productId, final Size size, final Integer stock) {
        var product = productFinder.findByIdOrThrow(productId);

        product.addVariant(new Variant(size, stock));

        productRepository.save(product);
    }
}
