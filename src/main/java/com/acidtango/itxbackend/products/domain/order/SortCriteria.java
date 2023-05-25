package com.acidtango.itxbackend.products.domain.order;

import com.acidtango.itxbackend.products.domain.Product;

import java.util.List;

public class SortCriteria {
    private final List<Criteria> sortCriteria;

    public SortCriteria(final List<Criteria> sortCriteria) {
        this.sortCriteria = sortCriteria;
    }

    public Integer getWeight(final Product product) {
        return sortCriteria.stream().map(criteria -> criteria.getScore(product)).reduce(0, Integer::sum);
    }
}
