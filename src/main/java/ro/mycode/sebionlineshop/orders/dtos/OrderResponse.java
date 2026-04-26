package ro.mycode.sebionlineshop.orders.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderResponse(
        Long id,
        Double amount,
        String shippingAddress,
        String orderAddress,
        String orderEmail,
        LocalDateTime orderDate,
        String orderStatus,
        Long customerId

) {
}
