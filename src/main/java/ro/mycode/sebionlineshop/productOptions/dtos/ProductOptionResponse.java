package ro.mycode.sebionlineshop.productOptions.dtos;

import lombok.Builder;

@Builder
public record ProductOptionResponse(
    Long id,
    Long productId,
    Long optionId
) {
}
