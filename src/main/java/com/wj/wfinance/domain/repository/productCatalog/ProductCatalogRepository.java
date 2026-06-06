package com.wj.wfinance.domain.repository.productCatalog;

import com.wj.wfinance.domain.entity.productCatalog.ProductCatalog;

import java.util.List;

public interface ProductCatalogRepository {

    List<ProductCatalog> findAll();
}
