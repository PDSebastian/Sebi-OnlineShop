package ro.mycode.sebionlineshop.productOptions.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductOptionRequest(
        Long id,
        @NotNull(message = "ID-ul produsului este obligatoriu")
        Long productId,

        @NotNull(message = "ID-ul opțiunii este obligatoriu")
        Long optionId
) {
}
