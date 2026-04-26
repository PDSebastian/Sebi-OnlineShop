package ro.mycode.sebionlineshop.orders.service;

import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;

import java.util.List;

public interface OrderQueryService {
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderById(Long id);
    List<OrderResponse> getOrdersByCustomerId(Long customerId);
    List<OrderResponse> getOrdersByStatus(String status);
    List<OrderResponse> getOrdersByEmail(String email);
}
