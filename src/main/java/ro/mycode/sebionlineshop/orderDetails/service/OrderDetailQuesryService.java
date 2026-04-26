package ro.mycode.sebionlineshop.orderDetails.service;

import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.model.OrderDetail;

import java.util.List;

public interface OrderDetailQuesryService {
    List<OrderDetailResponse> getAllOrderDetails();
    OrderDetailResponse getOrderDetailById(Long orderId);
    List<OrderDetailResponse> getOrderDetailByOrderStatus(String orderStatus);





}
