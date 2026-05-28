//package ro.mycode.sebionlineshop.orders.unitTests;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import ro.mycode.sebionlineshop.costumers.model.Costumer;
//import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
//import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
//import ro.mycode.sebionlineshop.orders.exceptions.OrderNotFoundException;
//import ro.mycode.sebionlineshop.orders.model.Order;
//import ro.mycode.sebionlineshop.orders.repository.OrderRepository;
//import ro.mycode.sebionlineshop.orders.service.OrderQueryServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class OrederQueryServiceUnitTests {
//    @Mock
//    OrderRepository orderRepository;
//    @Mock
//    CostumerRepository costumerRepository;
//    @InjectMocks
//    OrderQueryServiceImpl  orderQueryService;
//
//    @Test
//    public void testGetOrderById() throws OrderNotFoundException {
//        Long orderId = 1L;
//        Long customerId = 1L;
//        Double amount = 100.0;
//        String shippingAddress = "A";
//        String orderAddress = "B";
//        String orderEmail = "C";
//        String orderStatus = "D";
//
//        Costumer costumer = Costumer.builder()
//                .id(customerId)
//                .build();
//
//        Order order =Order.builder()
//                .amount(amount)
//                .shippingAddress(shippingAddress)
//                .orderAddress(orderAddress)
//                .orderEmail(orderEmail)
//                .orderStatus(orderStatus)
//                .costumer(costumer)
//                .build();
//
//        when(orderRepository.findOrderById(orderId)).thenReturn(order);
//        OrderResponse orderResponse = orderQueryService.getOrderById(orderId);
//       assertEquals(orderId,orderResponse);
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//}
