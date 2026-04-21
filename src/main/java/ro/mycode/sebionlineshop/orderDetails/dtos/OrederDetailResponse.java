package ro.mycode.sebionlineshop.orderDetails.dtos;

import java.time.LocalDateTime;

public record OrederDetailResponse(
        Long id,
        Double amount,
        String shippingAdress,
        String orderAdress,
        String orderEmail,
        LocalDateTime orderDate,
        String orderStatus


) {
}
