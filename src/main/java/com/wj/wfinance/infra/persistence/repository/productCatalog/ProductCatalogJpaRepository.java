package com.wj.wfinance.infra.persistence.repository.productCatalog;

import com.wj.wfinance.infra.persistence.entity.productCatalog.ProductCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCatalogJpaRepository extends JpaRepository<ProductCatalogEntity, Long> {
}
