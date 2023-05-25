package com.acidtango.itxbackend.products.domain.order;

import com.acidtango.itxbackend.products.domain.Product;

public class StockRatioCriteria extends Criteria {
    public StockRatioCriteria(final Integer weight) {
        super(weight);
    }

    public Integer getScore(final Product product) {
        return product.getStock() * weight;
    }
}
