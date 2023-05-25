package com.acidtango.itxbackend.products.domain;

import com.acidtango.itxbackend.products.domain.order.SortCriteria;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Products {
    final private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public Products order(SortCriteria sortCriteria) {
        var orderedProducts = products.stream()
                .sorted((product1, product2) -> sortCriteria.getWeight(product2).compareTo(sortCriteria.getWeight(product1)))
                .collect(Collectors.toList());
        return new Products(orderedProducts);
    }

    public List<Product> getItems() {
        return products;
    }

}
