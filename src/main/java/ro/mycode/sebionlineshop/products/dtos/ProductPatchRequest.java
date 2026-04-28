package ro.mycode.sebionlineshop.products.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductPatchRequest(
        @NotBlank(message = "Numele produsului este obligatoriu")
        String name,
        @NotNull(message = "Prețul este obligatoriu")
        @Min(value = 0, message = "Prețul nu poate fi negativ")
        Integer price
) {
}
