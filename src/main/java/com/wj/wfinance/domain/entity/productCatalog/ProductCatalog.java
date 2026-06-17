package com.wj.wfinance.domain.entity.productCatalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalog {

    private Long id;
    private String name;
    private String description;

}
