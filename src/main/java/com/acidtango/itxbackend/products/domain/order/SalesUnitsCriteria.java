package com.acidtango.itxbackend.products.domain.order;

import com.acidtango.itxbackend.products.domain.Product;

public class SalesUnitsCriteria extends Criteria {
    public SalesUnitsCriteria(final Integer weight) {
        super(weight);
    }

    public Integer getScore(final Product product) {
        return product.getSalesUnits() * weight;
    }
}
