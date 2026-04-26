package ro.mycode.sebionlineshop.orderDetails.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.exceptions.OrderDetailNotFoundException;
import ro.mycode.sebionlineshop.orderDetails.mapper.OrderDetailMapper;
import ro.mycode.sebionlineshop.orderDetails.repository.OrderDetailRepository;

import java.util.List;

@Component
public class OrderDetailQueryServiceImpl implements OrderDetailQuesryService{
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailQueryServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }
    @Override
    public List<OrderDetailResponse> getAllOrderDetails() {
        return orderDetailRepository.findAll()
                .stream()
                .map(OrderDetailMapper::toDto)
                .toList();
    }

    @Override
    public OrderDetailResponse getOrderDetailById(Long orderId) {
        return orderDetailRepository.findById(orderId)
                .map(OrderDetailMapper::toDto)
                .orElseThrow(()->new OrderDetailNotFoundException());
    }

    @Override
    public List<OrderDetailResponse> getOrderDetailByOrderStatus(String orderStatus) {
        return orderDetailRepository.findOrderDetailByOrderStatus(orderStatus)
                .stream()
                .map(OrderDetailMapper::toDto)
                .toList();




    }
}
