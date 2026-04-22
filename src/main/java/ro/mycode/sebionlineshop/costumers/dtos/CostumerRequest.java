package ro.mycode.sebionlineshop.costumers.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CostumerRequest(
        @NotBlank(message = "Emailul este obligatoriu")
     String email,
     @NotBlank(message = "Parola este obligatorie")
     String password,
     @NotBlank(message = "Numele este obligatoriu")
     String fullName,
        @NotBlank(message = "Adresa de facturare este obligatorie")
     String billingAddress,
     @NotBlank(message = "Adresa de livrare este obligatorie")
     String defaultShippingAddress,
     @NotBlank(message = "Tara este obligatorie")
     String country,
        @NotBlank(message = "Numărul de telefon este obligatoriu")
        String phone
) {
}
