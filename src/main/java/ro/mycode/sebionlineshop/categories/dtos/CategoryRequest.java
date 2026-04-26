package ro.mycode.sebionlineshop.categories.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CategoryRequest(
        @NotBlank(message = "Numele categoriei este obligatoriu")
        String name,
        @NotBlank(message = "Descrierea este obligatorie")
        String description,
        @NotBlank(message = "thumbnailul este obligatoriu")
        String thumbnail

        ) {

}
