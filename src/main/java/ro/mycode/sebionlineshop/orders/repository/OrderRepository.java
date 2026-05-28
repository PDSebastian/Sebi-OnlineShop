package ro.mycode.sebionlineshop.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByCostumerId(Long costomerId);
    List<Order> findAllByOrderStatus(String orderStatus);
    boolean existsByOrderEmail(String email);

    List<Order> findOrderByOrderEmail(String orderEmail);

    Order findOrderById(Long orderId);
}
