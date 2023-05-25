package com.acidtango.itxbackend.products.infrastructure.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreationDTO implements Serializable {
    private String name;
    private Integer salesUnits;

}