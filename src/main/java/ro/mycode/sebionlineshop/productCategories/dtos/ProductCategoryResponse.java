package ro.mycode.sebionlineshop.productCategories.dtos;

import lombok.Builder;

@Builder
public record ProductCategoryResponse(
        Long id,
        Long productId,
        Long categoryId
) {
}
