package ro.mycode.sebionlineshop.orders.mapper;

import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.orders.dtos.OrderRequest;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.model.Order;

public class OrderMapper {
    public static Order toEntity(OrderRequest orderRequest) {
        if (orderRequest == null) return null;
        return Order.builder()
                .amount(orderRequest.amount())
                .shippingAddress(orderRequest.shippingAddress())
                .orderAddress(orderRequest.orderAddress())
                .orderEmail(orderRequest.orderEmail())
                .orderDate(orderRequest.orderDate())
                .orderStatus(orderRequest.orderStatus())
                .build();

    }

    public static OrderResponse toDto(Order order) {
        if (order == null) return null;
        return new OrderResponse(
                order.getId(),
                order.getAmount(),
                order.getShippingAddress(),
                order.getOrderAddress(),
                order.getOrderEmail(),
                order.getOrderDate(),
                order.getOrderStatus(),
                order.getCostumer().getId()
        );
    }
}
