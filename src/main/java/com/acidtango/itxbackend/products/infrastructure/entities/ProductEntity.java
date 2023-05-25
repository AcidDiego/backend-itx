package com.acidtango.itxbackend.products.infrastructure.entities;

import com.acidtango.itxbackend.products.domain.Product;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Document("products")
public class ProductEntity {
    @Id
    private String productId;

    private String name;

    private Integer salesUnits;
    private List<VariantEntity> variants;

    public static ProductEntity fromDomain(Product product) {
        var newProductEntity = new ProductEntity();

        newProductEntity.productId = product.getProductId() == null ? newProductEntity.productId : product.getProductId();
        newProductEntity.name = product.getName();
        newProductEntity.salesUnits = product.getSalesUnits();
        newProductEntity.variants = new ArrayList();
        product.getVariants().forEach(variant -> newProductEntity.variants.add(VariantEntity.fromDomain(variant)));
        return newProductEntity;
    }

    public Product toDomain() {
        var variants = this.variants != null ? this.variants : new ArrayList<VariantEntity>();
        return new Product(this.productId, this.name, this.salesUnits, variants.stream().map(VariantEntity::toDomain).collect(Collectors.toList()));
    }
}
