package ro.mycode.sebionlineshop.orders.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.sebionlineshop.orders.dtos.OrderRequest;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.mapper.OrderMapper;
import ro.mycode.sebionlineshop.orders.model.Order;
import ro.mycode.sebionlineshop.orders.service.OrderCommandService;
import ro.mycode.sebionlineshop.orders.service.OrderQueryService;

@RestController
@RequestMapping("/api/v2/orders")
@Slf4j
public class OrdersController {
    private OrderCommandService orderCommandService;
    private OrderQueryService orderQueryService;
    public OrdersController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }
    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addOrder(@RequestBody OrderRequest orderRequest) {
        log.debug(" http://localhost:8080/api/v2/orders/add");
        Order order = OrderMapper.toEntity(orderRequest);
        OrderResponse response = orderCommandService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
}
