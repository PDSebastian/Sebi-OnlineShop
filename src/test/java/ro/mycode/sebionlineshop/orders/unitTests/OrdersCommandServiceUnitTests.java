package ro.mycode.sebionlineshop.orders.unitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.mycode.sebionlineshop.costumers.model.Costumer;
import ro.mycode.sebionlineshop.costumers.repository.CostumerRepository;
import ro.mycode.sebionlineshop.orders.dtos.OrderRequest;
import ro.mycode.sebionlineshop.orders.dtos.OrderResponse;
import ro.mycode.sebionlineshop.orders.exceptions.OrderNotFoundException;
import ro.mycode.sebionlineshop.orders.model.Order;
import ro.mycode.sebionlineshop.orders.repository.OrderRepository;
import ro.mycode.sebionlineshop.orders.service.OrderCommandServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrdersCommandServiceUnitTests {
    @Mock
    OrderRepository orderRepository;
    @Mock
    CostumerRepository costumerRepository;
    @InjectMocks
    OrderCommandServiceImpl orderCommandService;

    @Test
    public void testAddOrderReturnsOk(){
        Long customerId = 1L;
        Double amount = 100.0;
        String shippingAdress="A";
        String orderAdress="B";
        String orderEmail="C";
        String orderStatus="D";

        Costumer costumer = Costumer.builder()
                .id(customerId)
                .build();

        Order order=Order.builder()
                .amount(amount)
                .shippingAddress(shippingAdress)
                .orderAddress(orderAdress)
                .orderEmail(orderEmail)
                .orderStatus(orderStatus)
                .costumer(costumer)
                .build();

        OrderRequest orderRequest=OrderRequest.builder()
                .amount(amount)
                .shippingAddress(shippingAdress)
                .orderAddress(orderAdress)
                .orderEmail(orderEmail)
                .orderStatus(orderStatus)
                .customerId(customerId)
                .build();

        when(costumerRepository.findById(customerId)).thenReturn(Optional.of(costumer));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderResponse orderResponse=orderCommandService.addOrder(orderRequest);
        assertEquals(amount, orderResponse.amount());
        assertEquals(orderEmail, orderResponse.orderEmail());

    }
    @Test
    public void testDeleteOrderReturnsOk(){
        Long orderId = 1L;
        when(orderRepository.existsById(orderId)).thenReturn(true);
        orderCommandService.deleteOrder(orderId);
    }
    @Test
    public void testUpdateOrderReturnsOk(){
        Long orderId = 1L;
        Long customerId = 1L;
        Double amount = 100.0;
        String shippingAddress = "A";
        String orderAddress = "B";
        String orderEmail = "C";
        String orderStatus = "D";

        Costumer costumer = Costumer.builder()
                .id(customerId)
            .build();

        Order order = Order.builder()
                .amount(amount)
            .shippingAddress(shippingAddress)
            .orderAddress(orderAddress)
            .orderEmail(orderEmail)
            .orderStatus(orderStatus)
            .costumer(costumer)
            .build();

        OrderRequest orderRequest = OrderRequest.builder()
                .customerId(customerId)
            .amount(amount)
            .orderAddress(orderAddress)
            .orderEmail(orderEmail)
            .orderStatus(orderStatus)
            .build();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        when(costumerRepository.findById(customerId)).thenReturn(Optional.of(costumer));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderResponse orderResponse = orderCommandService.updateOrder(orderId, orderRequest);

        assertEquals(amount, orderResponse.amount());
        assertEquals(orderEmail, orderResponse.orderEmail());
    }
    @Test
    public void testDeleteOrderReturnsNotFound(){
        Long orderId = 1L;
        assertThrows(OrderNotFoundException.class, () -> orderCommandService.deleteOrder(orderId));
    }







}
