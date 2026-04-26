package ro.mycode.sebionlineshop.orderDetails.dtos;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record OrderDetailResponse(
        Long id,
        Double amount,
        String shippingAdress,
        String orderAdress,
        String orderEmail,
        LocalDateTime orderDate,
        String orderStatus


) {
}
