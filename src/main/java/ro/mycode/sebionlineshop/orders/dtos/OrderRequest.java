package ro.mycode.sebionlineshop.orders.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderRequest(
        @NotNull(message = "Suma totală este obligatorie")
        Double amount,
        @NotBlank(message = "Adresa de livrare este obligatorie")
        String shippingAddress,
        @NotBlank(message = "Adresa este obligatorie")
        String orderAddress,
        @NotBlank(message = "Emailul este obligatoriu")
        String orderEmail,
        @NotNull(message = "Data este obligatorie")
        LocalDateTime orderDate,
        @NotBlank(message = "Statutul comenzii este obligatoriu")
        String orderStatus

) {
}
