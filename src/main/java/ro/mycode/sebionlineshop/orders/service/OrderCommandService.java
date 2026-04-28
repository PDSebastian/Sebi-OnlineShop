package ro.mycode.sebionlineshop.orders.service;

import ro.mycode.sebionlineshop.orders.dtos.OrderRequest;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.model.Order;

public interface OrderCommandService {
    OrderResponse addOrder(OrderRequest orderRequest);
    OrderResponse updateOrder(Long id,OrderRequest  orderRequest);
    void deleteOrder(Long id);







}
