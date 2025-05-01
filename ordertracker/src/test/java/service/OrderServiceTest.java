package service;

import com.omkar.ordertracker.model.Order;
import com.omkar.ordertracker.repository.OrderRepository;
import com.omkar.ordertracker.service.OrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        order = new Order("ORD123", "Test Customer", "Processing", LocalDateTime.now());
        order.setId(1L);
    }

    @Test
    public void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));
        assertEquals(1, orderService.getAllOrders().size());
    }

    @Test
    public void testGetOrderByOrderId() {
        when(orderRepository.findByOrderId("ORD123")).thenReturn(Optional.of(order));
        Optional<Order> result = orderService.getOrderByOrderId("ORD123");
        assertTrue(result.isPresent());
        assertEquals("ORD123", result.get().getOrderId());
    }

    @Test
    public void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order created = orderService.createOrder(order);
        assertNotNull(created);
        assertEquals("ORD123", created.getOrderId());
    }

    @Test
    public void testDeleteOrder() {
        doNothing().when(orderRepository).deleteById(1L);
        orderService.deleteOrder(1L);
        verify(orderRepository, times(1)).deleteById(1L);
    }
}
