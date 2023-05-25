package com.acidtango.itxbackend.products.infrastructure.entities;

import com.acidtango.itxbackend.products.domain.Size;
import com.acidtango.itxbackend.products.domain.Variant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document("variant")
public class VariantEntity {

    @Id
    private String id;

    private Size size;

    private Integer stock;


    public static VariantEntity fromDomain(Variant variant) {
        var newVariantEntity = new VariantEntity();
        newVariantEntity.id = variant.getId();
        newVariantEntity.size = variant.getSize();
        newVariantEntity.stock = variant.getStock();
        return newVariantEntity;
    }

    public Variant toDomain() {
        var newVariant = new Variant();
        newVariant.setId(this.id);
        newVariant.setSize(this.size);
        newVariant.setStock(this.stock);

        return newVariant;
    }

}
