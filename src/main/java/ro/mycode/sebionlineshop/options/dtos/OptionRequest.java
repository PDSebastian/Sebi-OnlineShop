package ro.mycode.sebionlineshop.options.dtos;

import jakarta.validation.constraints.NotBlank;

public record OptionRequest(
        @NotBlank(message = "Numele opțiunii nu poate fi gol")
        String name
) {
}
