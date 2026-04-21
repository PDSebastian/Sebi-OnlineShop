package ro.mycode.sebionlineshop.orderDetails.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrederDetailRequest(
        @NotNull(message = "Suma totală este obligatorie")
         Double amount,
        @NotBlank(message = "Adresa de livrare este obligatorie")
        String shippingAdress,
        @NotBlank(message = "Adresa este obligatorie")
        String orderAdress,
        @NotBlank(message = "Emailul este obligatoriu")
        String orderEmail,
        @NotNull(message = "Data este obligatorie")
        LocalDateTime orderDate,
        @NotBlank(message = "Statutul comenzii este obligatoriu")
        String orderStatus







) {
}
