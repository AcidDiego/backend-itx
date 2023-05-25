package com.acidtango.itxbackend.products.application.useCases;

import com.acidtango.itxbackend.fixtures.ProductFixtures;
import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.Size;
import com.acidtango.itxbackend.products.infrastructure.repositories.ProductRepositoryMemory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductListerTest {

    @Test
    void list_all_orders_in_the_repository() {
        List<Product> savedProducts = List.of(ProductFixtures.COTTON_SHIRT(), ProductFixtures.FIT_SHIRT());
        ProductRepositoryMemory productRepository = new ProductRepositoryMemory(savedProducts);
        ProductLister productLister = new ProductLister(productRepository);

        var listedProducts = productLister.execute();

        assertEquals(listedProducts.getItems().size(), savedProducts.size());
        assertEquals(listedProducts.getProducts().get(0).getProductId(), savedProducts.get(0).getProductId());
    }

    @Test
    void sort_all_products_by_stock() {
        Product maxStockProduct = new Product(ProductFixtures.FIT_SHIRT());
        maxStockProduct.setVariantStock(Size.MEDIUM, 1000);
        Product minStockProduct = ProductFixtures.COTTON_SHIRT();
        List<Product> savedProducts = List.of(minStockProduct, maxStockProduct);
        ProductRepositoryMemory productRepository = new ProductRepositoryMemory(savedProducts);
        ProductLister productLister = new ProductLister(productRepository);

        var listedProducts = productLister.execute();

        assertEquals(listedProducts.getItems().size(), savedProducts.size());
        assertEquals(listedProducts.getProducts().get(0).getProductId(), maxStockProduct.getProductId());
    }

    @Test
    void sort_all_products_by_sells() {
        Product maxSellProduct = new Product(ProductFixtures.FIT_SHIRT());
        maxSellProduct.updateSaleUnits(1000);
        Product minSellProduct = ProductFixtures.COTTON_SHIRT();
        List<Product> savedProducts = List.of(minSellProduct, maxSellProduct);
        ProductRepositoryMemory productRepository = new ProductRepositoryMemory(savedProducts);
        ProductLister productLister = new ProductLister(productRepository);

        var listedProducts = productLister.execute();

        assertEquals(listedProducts.getItems().size(), savedProducts.size());
        assertEquals(listedProducts.getProducts().get(0).getProductId(), maxSellProduct.getProductId());
    }

    @Test
    void sort_all_products_by_weight() {
        Integer increment = 20;
        // MaxStock
        Product maxStockProduct = new Product(ProductFixtures.FIT_SHIRT());
        maxStockProduct.setVariantStock(Size.SMALL, maxStockProduct.getVariants().get(0).getStock() + increment);
        //Max sales
        Product maxSellProduct = ProductFixtures.COTTON_SHIRT();
        maxSellProduct.updateSaleUnits(maxSellProduct.getSalesUnits() + increment);
        //List
        List<Product> savedProducts = List.of(maxSellProduct, maxStockProduct);
        ProductRepositoryMemory productRepository = new ProductRepositoryMemory(savedProducts);
        ProductLister productLister = new ProductLister(productRepository);

        var listedProducts = productLister.execute(100, 1);

        assertEquals(listedProducts.getItems().size(), savedProducts.size());
        assertEquals(listedProducts.getProducts().get(0).getProductId(), maxStockProduct.getProductId());
    }

}
