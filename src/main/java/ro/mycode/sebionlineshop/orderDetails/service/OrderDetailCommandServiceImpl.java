package ro.mycode.sebionlineshop.orderDetails.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.exceptions.OrderDetailNotFoundException;
import ro.mycode.sebionlineshop.orderDetails.mapper.OrderDetailMapper;
import ro.mycode.sebionlineshop.orderDetails.model.OrderDetail;
import ro.mycode.sebionlineshop.orderDetails.repository.OrderDetailRepository;

@Component

public class OrderDetailCommandServiceImpl implements OrderDetailCommandService {

    private final OrderDetailRepository orderDetailRepository;
    private final CostumerRepository costumerRepository;

    public OrderDetailCommandServiceImpl(OrderDetailRepository orderDetailRepository, CostumerRepository costumerRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.costumerRepository = costumerRepository;
    }

    @Override
    @Transactional
    public OrderDetailResponse addOrderDetail(Long costumerId,OrderDetail orderDetail) {
        costumerRepository.findById(costumerId)
                .orElseThrow(()->new CostumerNotFoundException());

        OrderDetail saved = orderDetailRepository.save(orderDetail);

        return OrderDetailMapper.toDto(saved);
    }

    @Override
    @Transactional
    public OrderDetailResponse updateOrderDetail(OrderDetail orderDetail) {
        if(orderDetailRepository.existsById(orderDetail.getId())){
            throw new OrderDetailNotFoundException();
        }
        OrderDetail saved = orderDetailRepository.save(orderDetail);
        return OrderDetailMapper.toDto(saved);
    }

    @Override
    @Transactional
    public OrderDetailResponse deleteOrderDetail(Long orderId) {
        OrderDetail orderDetail = orderDetailRepository.findById(orderId)
                .orElseThrow(()->new OrderDetailNotFoundException());
        OrderDetailResponse response = OrderDetailMapper.toDto(orderDetail);
        orderDetailRepository.deleteById(orderId);
        return response;
    }
}

