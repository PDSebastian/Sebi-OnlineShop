package ro.mycode.sebionlineshop.costumers.dtos;

import lombok.Builder;
import lombok.Getter;


@Builder

public record CostumerResponse(
        Long id,
        String email,
        String password,
        String fullName,
        String billingAddress,
        String defaultShippingAddress,
        String country,
        String phoneNumber
) {}
