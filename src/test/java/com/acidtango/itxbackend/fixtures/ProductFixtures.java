package com.acidtango.itxbackend.fixtures;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.Variant;

import java.util.ArrayList;
import java.util.List;

public class ProductFixtures {

    public static final Product COTTON_SHIRT() {
        return new Product(
                "cotton-shirt-id",
                "V-NECH BASIC SHIRT",
                100,
                List.of(VariantFixture.SMALL_VARIANT(), VariantFixture.MEDIUM_VARIANT(), VariantFixture.LARGE_VARIANT()));
    }

    public static final Product FIT_SHIRT() {
        return new Product(
                "fit-shirt-id",
                "CONTRASTING FABRIC T-SHIRT",
                100,
                List.of(VariantFixture.SMALL_VARIANT(), VariantFixture.MEDIUM_VARIANT(), VariantFixture.LARGE_VARIANT()));
    }

    public static final Product SHIRT_WITHOUT_VARIANT() {
        return new Product(
                "fit-shirt-id",
                "CONTRASTING FABRIC T-SHIRT",
                100,
                new ArrayList<Variant>());
    }
}
