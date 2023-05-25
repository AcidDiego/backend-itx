package com.acidtango.itxbackend.fixtures;

import com.acidtango.itxbackend.products.domain.Size;
import com.acidtango.itxbackend.products.domain.Variant;

public class VariantFixture {

    final public static Variant SMALL_VARIANT() {
        return new Variant("small-variant-id", Size.SMALL, 10);
    }

    final public static Variant MEDIUM_VARIANT() {
        return new Variant("medium-variant-id", Size.MEDIUM, 10);
    }

    final public static Variant LARGE_VARIANT() {
        return new Variant("large-variant-id", Size.LARGE, 10);
    }
}
