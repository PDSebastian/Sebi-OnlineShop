package ro.mycode.sebionlineshop.orderDetails.service;

import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrederDetailRequest;

public interface OrderDetailCommandService {
    OrderDetailResponse addOrderDetail(Long costumerId, OrederDetailRequest request);
    OrderDetailResponse updateOrderDetail(Long id,OrederDetailRequest request);
    OrderDetailResponse deleteOrderDetail(Long orderId);

}
