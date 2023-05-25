package com.acidtango.itxbackend.products.infrastructure.controllers.dtos;

import com.acidtango.itxbackend.products.domain.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariantCreationDTO implements Serializable {

    private Integer stock;
    private Size size;

}