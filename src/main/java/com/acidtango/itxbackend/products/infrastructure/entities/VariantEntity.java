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


}
