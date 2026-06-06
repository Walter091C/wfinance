package com.wj.wfinance.application.useCase.productCatalog;

import com.wj.wfinance.domain.entity.productCatalog.ProductCatalog;
import com.wj.wfinance.domain.repository.productCatalog.ProductCatalogRepository;

import java.util.List;

public class ShowProductCatalogUseCase {

    private final ProductCatalogRepository productCatalogRepository;

    public ShowProductCatalogUseCase(ProductCatalogRepository productCatalogRepository) {
        this.productCatalogRepository = productCatalogRepository;
    }

    public List<ProductCatalog> showProductCatalog() {
        return productCatalogRepository.findAll();
    }
}
