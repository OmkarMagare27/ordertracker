package com.omkar.ordertracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omkar.ordertracker.model.Order;
import com.omkar.ordertracker.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private Order testOrder;

    @BeforeEach
    void setUp() {
        testOrder = new Order("ORD123", "Test User", "Processing", LocalDateTime.now());
        testOrder.setId(1L);
    }

    @Test
    void testGetAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(Arrays.asList(testOrder));

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].orderId").value("ORD123"));
    }

    @Test
    void testGetOrderByOrderId() throws Exception {
        when(orderService.getOrderByOrderId("ORD123")).thenReturn(Optional.of(testOrder));

        mockMvc.perform(get("/orders/ORD123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Test User"));
    }

    @Test
    void testCreateOrder() throws Exception {
        when(orderService.createOrder(any(Order.class))).thenReturn(testOrder);

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules(); // ✅ Fix for LocalDateTime serialization

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(testOrder)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").value("ORD123"));
    }

    @Test
    void testDeleteOrder() throws Exception {
        doNothing().when(orderService).deleteOrder(1L);

        mockMvc.perform(delete("/orders/1"))
                .andExpect(status().isNoContent());
    }
}
