package ro.mycode.sebionlineshop.orderDetails.mapper;

import ro.mycode.sebionlineshop.orderDetails.dtos.OrderDetailResponse;
import ro.mycode.sebionlineshop.orderDetails.model.OrderDetail;
import ro.mycode.sebionlineshop.orderDetails.dtos.OrederDetailRequest;


public class OrderDetailMapper {
    public static OrderDetail toEntity(OrederDetailRequest orderDetailRequest) {
        if (orderDetailRequest == null) {
            return null;
        }
        return OrderDetail.builder()
                .orderStatus(orderDetailRequest.orderStatus())
                .orderDate(orderDetailRequest.orderDate())
                .orderEmail(orderDetailRequest.orderEmail())
                .amount(orderDetailRequest.amount())
                .shippingAddress(orderDetailRequest.shippingAdress())
                .build();
    }
    public static OrderDetailResponse toDto(OrderDetail orderDetail) {
        if (orderDetail == null) {
            return null;
        }
        return  OrderDetailResponse.builder()
                .amount(orderDetail.getAmount())
                .shippingAdress(orderDetail.getShippingAddress())
                .orderAdress(orderDetail.getOrderAddress())
                .orderEmail(orderDetail.getOrderEmail())
                .orderDate(orderDetail.getOrderDate())
                .orderStatus(orderDetail.getOrderStatus())
                .build();
    }





}
