package ro.mycode.sebionlineshop.orderDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.sebionlineshop.orderDetails.model.OrderDetail;

import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
        Optional<OrderDetail>  findByOrderId(Long orderId);
        Optional<OrderDetail>  findOrderDetailByOrderStatus(String orderStatus);






}
