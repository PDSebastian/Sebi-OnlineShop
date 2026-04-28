package ro.mycode.sebionlineshop.orderDetails.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrederDetailRequest;
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
    public OrderDetailResponse addOrderDetail(Long costumerId, OrederDetailRequest request) {
        costumerRepository.findById(costumerId)
                .orElseThrow(() -> new CostumerNotFoundException());

        OrderDetail orderDetail = OrderDetailMapper.toEntity(request);

        OrderDetail saved = orderDetailRepository.save(orderDetail);
        return OrderDetailMapper.toDto(saved);
    }

    @Override
    @Transactional
    public OrderDetailResponse updateOrderDetail(Long id, OrederDetailRequest request) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new OrderDetailNotFoundException());
        orderDetail.setOrderAddress(request.orderAdress());
        orderDetail.setOrderEmail(request.orderEmail());
        orderDetail.setOrderDate(request.orderDate());

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

