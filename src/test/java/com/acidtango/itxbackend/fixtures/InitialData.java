package com.acidtango.itxbackend.fixtures;

import com.acidtango.itxbackend.products.domain.Product;
import com.acidtango.itxbackend.products.domain.Size;
import com.acidtango.itxbackend.products.domain.Variant;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
public class InitialData {

    static public List<Product> INITIAL_DATA = List.of(
            new Product("1", "V-NECH BASIC SHIRT", 100,
                    List.of(new Variant(Size.SMALL, 4), new Variant(Size.MEDIUM, 9), new Variant(Size.LARGE, 0))),
            new Product("2", "CONTRASTING FABRIC T-SHIRT", 50,
                    List.of(new Variant(Size.SMALL, 35), new Variant(Size.MEDIUM, 9), new Variant(Size.LARGE, 9))),
            new Product("3", "RAISED PRINT T-SHIRT", 80,
                    List.of(new Variant(Size.SMALL, 20), new Variant(Size.MEDIUM, 2), new Variant(Size.LARGE, 20))),
            new Product("4", "PLEATED T-SHIRT", 3,
                    List.of(new Variant(Size.SMALL, 25), new Variant(Size.MEDIUM, 30), new Variant(Size.LARGE, 10))),
            new Product("5", "CONTRASTING LACE T-SHIRT", 650,
                    List.of(new Variant(Size.SMALL, 0), new Variant(Size.MEDIUM, 1), new Variant(Size.LARGE, 0))),
            new Product("6", "SLOGAN T-SHIRT", 20,
                    List.of(new Variant(Size.SMALL, 9), new Variant(Size.MEDIUM, 2), new Variant(Size.LARGE, 5)))
    );
}
