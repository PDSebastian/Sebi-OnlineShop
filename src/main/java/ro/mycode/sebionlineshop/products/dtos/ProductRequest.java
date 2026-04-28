package ro.mycode.sebionlineshop.products.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductRequest(
        Long id,


        @NotBlank(message = "SKU-ul este obligatoriu")
        String sku,

        @NotBlank(message = "Numele produsului este obligatoriu")
        String name,

        @NotNull(message = "Prețul este obligatoriu")
        @Min(value = 0, message = "Prețul nu poate fi negativ")
        Integer price,

        @NotNull(message = "Greutatea este obligatorie")
        @Min(value = 0, message = "Greutatea nu poate fi negativă")
        Integer weight,

        @NotBlank(message = "Descrierea este obligatorie")
        String descriptions,

        @NotBlank(message = "Thumbnail-ul este obligatoriu")
        String thumbnail,

        @NotBlank(message = "Imaginea este obligatorie")
        String image,



        @NotBlank(message = "Categorie din care face parte produsul este obligatorie")
        String category




) {
}
