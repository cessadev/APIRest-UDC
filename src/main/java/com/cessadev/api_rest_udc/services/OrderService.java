package com.cessadev.api_rest_udc.services;

import com.cessadev.api_rest_udc.dao.repositories.CustomerRepository;
import com.cessadev.api_rest_udc.dao.repositories.OrderRepository;
import com.cessadev.api_rest_udc.model.dtos.OrderDTO;
import com.cessadev.api_rest_udc.model.dtos.OrderResultDTO;
import com.cessadev.api_rest_udc.model.dtos.PagingDataDTO;
import com.cessadev.api_rest_udc.model.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public OrderResultDTO getOrdersByFilter(
            int filter, String orderNumber, String since, String until, String status, String customerEmail, int page, int size) {

        // 1 - orderNumber, 2 - orderDate, 3 - deliveryDate, 4 - status
        try {
            // Check if customer exists
            Customer customer = customerRepository.findByEmail(customerEmail).orElseThrow(
                    () -> new RuntimeException("Customer not found")
            );

            LocalDateTime sinceDate = null;
            LocalDateTime untilDate = null;

            try {
                if (filter == 2 || filter == 3) {
                    sinceDate = LocalDateTime.parse(since, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    untilDate = LocalDateTime.parse(until, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                }

                List<OrderDTO> orders = orderRepository.findByFilter(filter, orderNumber, sinceDate, untilDate, status, customer.getId(), page, size);

                int total = orderRepository.countFindByFilter(filter, orderNumber, sinceDate, untilDate, status, customer.getId());

                PagingDataDTO pagingData = new PagingDataDTO(page, size, total);

                return new OrderResultDTO(orders, pagingData);

            } catch (DateTimeParseException exception) {
                throw new RuntimeException("Invalid date format");
            }

        } catch (RuntimeException exception) {
            return new OrderResultDTO("L001", exception.getMessage());
        }
    }
}
