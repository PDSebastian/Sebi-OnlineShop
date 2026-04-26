package ro.mycode.sebionlineshop.orders.service;

import org.springframework.stereotype.Component;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.exceptions.OrderNotFoundException;
import ro.mycode.sebionlineshop.orders.mapper.OrderMapper;
import ro.mycode.sebionlineshop.orders.model.Order;
import ro.mycode.sebionlineshop.orders.repository.OrderRepository;

import java.util.List;

@Component
public class OrderQueryServiceImpl implements OrderQueryService {
    private OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
       List<Order> orders=orderRepository.findAll();
       if(orders.isEmpty()){
           throw new OrderNotFoundException();
       }
       return orders.stream().map(OrderMapper::toDto).toList();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id).map(OrderMapper::toDto).orElseThrow(()->new OrderNotFoundException());
    }

    @Override
    public List<OrderResponse> getOrdersByCustomerId(Long customerId) {
        List<Order>orders=orderRepository.findAllByCostumerId(customerId);
        if(orders.isEmpty()){
            throw new OrderNotFoundException();
        }
        return orders.stream().map(OrderMapper::toDto).toList();
    }

    @Override
    public List<OrderResponse> getOrdersByStatus(String status) {
       List<Order>orders=orderRepository.findAllByOrderStatus(status);
       if(orders.isEmpty()){
           throw new OrderNotFoundException();
       }
       return orders.stream().map(OrderMapper::toDto).toList();
    }

    @Override
    public List<OrderResponse> getOrdersByEmail(String email) {
        List<Order>orders=orderRepository.findOrderByOrderEmail(email);
        if(orders.isEmpty()){
            throw new OrderNotFoundException();
        }
        return orders.stream().map(OrderMapper::toDto).toList();
    }
}
