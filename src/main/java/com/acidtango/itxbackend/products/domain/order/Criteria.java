package com.acidtango.itxbackend.products.domain.order;

import com.acidtango.itxbackend.products.domain.Product;

abstract public class Criteria {
    final protected Integer weight;

    public Criteria(final Integer weight) {
        this.weight = weight;
    }

    abstract Integer getScore(Product product);
}
