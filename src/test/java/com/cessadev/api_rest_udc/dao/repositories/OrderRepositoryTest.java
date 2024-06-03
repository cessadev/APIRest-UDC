package com.cessadev.api_rest_udc.dao.repositories;

import com.cessadev.api_rest_udc.model.dtos.OrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer
            = new PostgreSQLContainer<>("postgres:16-alpine3.19");

    @Test
    void connectionTest() {
        assertTrue(postgreSQLContainer.isCreated());
        assertTrue(postgreSQLContainer.isRunning());
    }

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void shouldFindOrderByOrderNumber() {
        // given
        String orderNumber = "ORD-0002";
        // when
        var order = orderRepository.findByOrderNumber(orderNumber);
        // then
        assertTrue(order.isPresent());
    }

    @Test
    void shouldNotFindOrderByOrderNumber() {
        // given
        String orderNumber = "ORD-0002999999";
        // when
        var order = orderRepository.findByOrderNumber(orderNumber);
        // then
        assertTrue(order.isEmpty());
    }

    @Test
    void shouldFindTwoOrderByDeliveryStatus() {
        // given
        String deliveryStatus = "DELIVERED";
        // when
        // filter, orderNumber, since, until, status, customerId, page, size
        List<OrderDTO> orders = orderRepository.findByFilter(
                4, null, null, null, deliveryStatus, null,0, 10);
        // then
        assertEquals(2, orders.size());
    }

    @Test
    void shouldCountByDeliveryStatus() {
        // given
        String deliveryStatus = "DELIVERED";
        // when
        // filter, orderNumber, since, until, status, customerId
        int totalRegister = orderRepository.countFindByFilter(
                4, null, null, null, deliveryStatus, null);
        // then
        assertEquals(2, totalRegister);
    }
}
