package com.wj.wfinance.presentation.controller.productCatalog;

import com.wj.wfinance.application.useCase.productCatalog.ShowProductCatalogUseCase;
import com.wj.wfinance.presentation.response.user.ListProductCatalogResponse;
import com.wj.wfinance.presentation.response.user.ProductCatalogResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-catalog")
@SecurityRequirement(name = "Product Catalog")
@Tag(name = "Product Catalog", description = "Operações relacionadas ao catálogo de produtos, incluindo consulta de produtos disponíveis e detalhes dos produtos.")
public class ProductCatalogController {

    private final ShowProductCatalogUseCase showProductCatalogUseCase;

    public ProductCatalogController(ShowProductCatalogUseCase showProductCatalogUseCase) {
        this.showProductCatalogUseCase = showProductCatalogUseCase;
    }

    @GetMapping
    public ResponseEntity<ListProductCatalogResponse> getProductCatalog() {
        return ResponseEntity.ok(
                new ListProductCatalogResponse(
                        showProductCatalogUseCase.showProductCatalog().stream()
                                .map(product -> new ProductCatalogResponse(product.getName(), product.getDescription()))
                                .toList()
                )
        );
    }
}
