package com.acidtango.itxbackend.products.application.useCases;

import com.acidtango.itxbackend.products.domain.ProductRepository;
import com.acidtango.itxbackend.products.domain.Products;
import com.acidtango.itxbackend.products.domain.order.SalesUnitsCriteria;
import com.acidtango.itxbackend.products.domain.order.SortCriteria;
import com.acidtango.itxbackend.products.domain.order.StockRatioCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLister {
    private final ProductRepository productRepository;

    public ProductLister(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Products execute(final Integer stockRatioWeight,final Integer salesUnitsWeight) {
        var stockCriteria =
                new StockRatioCriteria(stockRatioWeight);
        var salesUnitsCriteria =
                new SalesUnitsCriteria(salesUnitsWeight);
        var sortCriteria =
                new SortCriteria(List.of(stockCriteria, salesUnitsCriteria));
        var products = productRepository.findAll();
        return products.order(sortCriteria);
    }

    public Products execute() {
        return this.execute(1, 1);
    }

}
