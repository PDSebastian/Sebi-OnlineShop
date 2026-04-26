package ro.mycode.sebionlineshop.orders.service;

import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.model.Order;

public interface OrderCommandService {
    OrderResponse addOrder(Order order);
    OrderResponse updateOrder(Order order);
    void deleteOrder(Order order);







}
