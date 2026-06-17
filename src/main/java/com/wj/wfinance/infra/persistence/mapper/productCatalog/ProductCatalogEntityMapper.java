package com.wj.wfinance.infra.persistence.mapper.productCatalog;

import com.wj.wfinance.domain.entity.productCatalog.ProductCatalog;
import com.wj.wfinance.infra.persistence.entity.productCatalog.ProductCatalogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCatalogEntityMapper {

    ProductCatalog toDomain(ProductCatalogEntity productCatalogEntity);

    ProductCatalogEntity toEntity(ProductCatalog productCatalog);
}
