package ro.mycode.sebionlineshop.productCategories.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductCategoryRequest(
        @NotNull(message = "ID-ul produsului este obligatoriu")
        Long productId,

        @NotNull(message = "ID-ul categoriei este obligatoriu")
        Long categoryId


) {
}
