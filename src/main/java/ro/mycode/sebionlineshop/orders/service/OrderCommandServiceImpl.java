package ro.mycode.sebionlineshop.orders.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.exceptions.OrderAlreadyExistsException;
import ro.mycode.sebionlineshop.orders.exceptions.OrderNotFoundException;
import ro.mycode.sebionlineshop.orders.mapper.OrderMapper;
import ro.mycode.sebionlineshop.orders.model.Order;
import ro.mycode.sebionlineshop.orders.repository.OrderRepository;

@Component
public class OrderCommandServiceImpl implements OrderCommandService {
    public final OrderRepository orderRepository;
    public final CostumerRepository costumerRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository,CostumerRepository costumerRepository) {
        this.orderRepository = orderRepository;
        this.costumerRepository = costumerRepository;
    }


    @Override
    @Transactional
    public OrderResponse addOrder(Order order) {
        if(orderRepository.existsById(order.getId())){
        throw new OrderAlreadyExistsException();
        }
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDto(savedOrder);

    }

    @Override
    @Transactional
    public OrderResponse updateOrder(Order order) {
        if(!orderRepository.existsById(order.getId())){
            throw new OrderNotFoundException();
        }
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDto(savedOrder);
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        if(!orderRepository.existsById(order.getId())){
            throw new OrderNotFoundException();
        }
        orderRepository.delete(order);
    }
}
