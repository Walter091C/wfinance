package com.wj.wfinance.infra.persistence.adapter.productCatalog;

import com.wj.wfinance.domain.entity.productCatalog.ProductCatalog;
import com.wj.wfinance.domain.repository.productCatalog.ProductCatalogRepository;
import com.wj.wfinance.infra.persistence.mapper.productCatalog.ProductCatalogEntityMapper;
import com.wj.wfinance.infra.persistence.repository.productCatalog.ProductCatalogJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalogRepositoryAdapter implements ProductCatalogRepository {

    private final ProductCatalogJpaRepository productCatalogJpaRepository;
    private final ProductCatalogEntityMapper productCatalogMapper;

    public ProductCatalogRepositoryAdapter(ProductCatalogJpaRepository productCatalogJpaRepository, ProductCatalogEntityMapper productCatalogMapper) {
        this.productCatalogJpaRepository = productCatalogJpaRepository;
        this.productCatalogMapper = productCatalogMapper;
    }

    @Override
    public List<ProductCatalog> findAll() {
        return productCatalogJpaRepository.findAll().stream()
                .map(productCatalogMapper::toDomain)
                .collect(Collectors.toList());
    }
}
