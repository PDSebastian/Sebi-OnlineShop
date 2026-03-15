package ro.mycode.sebionlineshop.costumers.dtos;

public record CostumerResponse(
        Long id,
        String email,
        String password,
        String fullName,
        String billingAddress,
        String defaultShippingAddress,
        String country,
        String phone
) {}

