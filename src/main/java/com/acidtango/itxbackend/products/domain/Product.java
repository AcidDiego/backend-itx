package com.acidtango.itxbackend.products.domain;

import com.acidtango.itxbackend.products.domain.exceptions.VariantNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String productId;

    private String name;

    private Integer salesUnits;

    private List<Variant> variants;


    public Product(String name, Integer salesUnits) {
        this.name = name;
        this.variants = new ArrayList();
        this.salesUnits = salesUnits;
    }

    public Product(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.variants = product.getVariants();
        this.salesUnits = product.salesUnits;
    }

    public Product(String name, Integer salesUnits, List<Variant> variants) {
        this.name = name;
        this.variants = variants;
        this.salesUnits = salesUnits;
    }

    public void addVariant(Variant newVariant) {
        variants.add(newVariant);
    }

    public Integer getStock() {
        return variants.stream().map(Variant::getStock).reduce(0, Integer::sum);
    }

    public void setVariantStock(Size size, int stock) {
        var editedVariant = this.variants.stream().filter(variant -> variant.getSize() == size).findAny();
        editedVariant.ifPresentOrElse(variant -> variant.setStock(stock), () -> {
            throw new VariantNotFoundException(size);
        });
    }

    public void updateSaleUnits(Integer sells) {
        this.salesUnits = sells;
    }
}
