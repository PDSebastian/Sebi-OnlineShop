package ro.mycode.sebionlineshop.orders.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.sebionlineshop.costumers.exceptions.CostumerNotFoundException;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.orders.dtos.OrderRequest;
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
    public OrderResponse addOrder(OrderRequest request) {
        Costumer costumer = costumerRepository.findById(request.customerId())
                .orElseThrow(CostumerNotFoundException::new);
        Order order = OrderMapper.toEntity(request);
        order.setCostumer(costumer);

        return OrderMapper.toDto(orderRepository.save(order));
    }

    @Override
    @Transactional
    public OrderResponse updateOrder(Long id, OrderRequest orderRequest) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException());

        Costumer costumer = costumerRepository.findById(orderRequest.customerId())
                .orElseThrow(() -> new CostumerNotFoundException());

        order.setAmount(orderRequest.amount());
        order.setShippingAddress(orderRequest.shippingAddress());
        order.setOrderAddress(orderRequest.orderAddress());
        order.setOrderEmail(orderRequest.orderEmail());
        order.setOrderStatus(orderRequest.orderStatus());
        order.setCostumer(costumer);
        Order updatedOrder = orderRepository.save(order);

        return OrderMapper.toDto(updatedOrder);
    }
    @Override
    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        }
        orderRepository.deleteById(id);
    }
}
