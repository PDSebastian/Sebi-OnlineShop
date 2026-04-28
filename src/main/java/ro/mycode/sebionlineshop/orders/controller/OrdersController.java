package ro.mycode.sebionlineshop.orders.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.orders.dtos.OrderRequest;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.mapper.OrderMapper;
import ro.mycode.sebionlineshop.orders.model.Order;
import ro.mycode.sebionlineshop.orders.service.OrderCommandService;
import ro.mycode.sebionlineshop.orders.service.OrderQueryService;

import java.util.List;
import java.util.Map;

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
        OrderResponse response = orderCommandService.addOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        log.debug("http://localhost:8080/api/v2/orders/update/{id}", id);
        OrderResponse response = orderCommandService.updateOrder(id, orderRequest);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.debug(" http://localhost:8080/api/v2/orders/delete/{id}", id);
        orderCommandService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        log.debug("http://localhost:8080/api/v2/orders/all");
        return ResponseEntity.ok(orderQueryService.getAllOrders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
            log.debug("http://localhost:8080/api/v2/orders/{}", id);
        return ResponseEntity.ok(orderQueryService.getOrderById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerId(@PathVariable Long customerId) {
        log.debug(" http://localhost:8080/api/v2/orders/customer/{}", customerId);
        return ResponseEntity.ok(orderQueryService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<OrderResponse>> getOrdersByStatus(@PathVariable String status) {
        log.debug(" http://localhost:8080/api/v2/orders/status/{}", status);
        return ResponseEntity.ok(orderQueryService.getOrdersByStatus(status));
    }


}
