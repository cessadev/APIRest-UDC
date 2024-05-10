package com.cessadev.api_rest_udc.model.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public record OrderDTO(
    long id,
    String orderNumber,
    LocalDateTime orderDate,
    LocalDateTime deliveryDate,
    String status,
    CustomerDTO customer) implements Serializable {
}
