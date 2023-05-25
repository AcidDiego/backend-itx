package com.acidtango.itxbackend.products.infrastructure.entities;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.infrastructure.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class ProductEntity {
    @Id
    private String productId;

    private String name;

    private Integer salesUnits;
    private List<VariantEntity> variants;

}
