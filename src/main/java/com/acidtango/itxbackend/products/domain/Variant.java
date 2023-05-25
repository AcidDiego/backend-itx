package com.acidtango.itxbackend.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Variant {

    @Id
    private String id;

    private Size size;

    private Integer stock;

    public Variant(Size size, Integer stock) {
        this.size = size;
        this.stock = stock;
    }

}
