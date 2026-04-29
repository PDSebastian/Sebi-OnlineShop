package ro.mycode.sebionlineshop.orderDetails.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrederDetailRequest;
import ro.mycode.sebionlineshop.orderDetails.service.OrderDetailCommandService;
import ro.mycode.sebionlineshop.orderDetails.service.OrderDetailQuesryService;


import java.util.List;

@RestController
@RequestMapping("/api/v2/order-details")
@Slf4j
public class OrderDetailsController {
    private OrderDetailCommandService orderDetailCommandService;
    private OrderDetailQuesryService  orderDetailQuesryService;
    public OrderDetailsController(OrderDetailQuesryService orderDetailQuesryService, OrderDetailCommandService orderDetailCommandService) {
        this.orderDetailQuesryService = orderDetailQuesryService;
        this.orderDetailCommandService = orderDetailCommandService;


    }
    @PostMapping("/add/{costumerId}")
    public ResponseEntity<OrderDetailResponse> addOrderDetail(@PathVariable Long costumerId, @RequestBody OrederDetailRequest request) {
        log.debug(" http://localhost:8080/api/v2/order-details/add/{}", costumerId);
        OrderDetailResponse response = orderDetailCommandService.addOrderDetail(costumerId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrderDetailResponse>> getAllOrderDetails() {
        log.debug("http://localhost:8080/api/v2/order-details/all");
        return ResponseEntity.ok(orderDetailQuesryService.getAllOrderDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailResponse> getOrderDetailById(@PathVariable Long id) {
        log.debug("http://localhost:8080/api/v2/order-details/{id}", id);
        return ResponseEntity.ok(orderDetailQuesryService.getOrderDetailById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<OrderDetailResponse>> getOrderDetailByStatus(@PathVariable String status) {
        log.debug(" http://localhost:8080/api/v2/order-details/status/{id}", status);
        return ResponseEntity.ok(orderDetailQuesryService.getOrderDetailByOrderStatus(status));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDetailResponse> updateOrderDetail(@PathVariable Long id, @RequestBody OrederDetailRequest request) {
        log.debug("http://localhost:8080/api/v2/order-details/update/{id}", id);
        return ResponseEntity.ok(orderDetailCommandService.updateOrderDetail(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDetailResponse> deleteOrderDetail(@PathVariable Long id) {
        log.debug("http://localhost:8080/api/v2/order-details/delete/{id}", id);
        orderDetailCommandService.deleteOrderDetail(id);
        return ResponseEntity.ok(orderDetailQuesryService.getOrderDetailById(id));

    }






}
