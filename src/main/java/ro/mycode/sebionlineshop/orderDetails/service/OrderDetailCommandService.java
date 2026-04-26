package ro.mycode.sebionlineshop.orderDetails.service;

import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.model.OrderDetail;

public interface OrderDetailCommandService {
    OrderDetailResponse addOrderDetail(Long costumerId,OrderDetail orderDetail);
    OrderDetailResponse updateOrderDetail(OrderDetail orderDetail);
    OrderDetailResponse deleteOrderDetail(Long orderId);

}
