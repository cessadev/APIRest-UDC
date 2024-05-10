package com.cessadev.api_rest_udc.dao.extended;

import com.cessadev.api_rest_udc.model.dtos.OrderDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderExtRepo {

    List<OrderDTO> findByFilter(
            int filter, String orderNumber, LocalDateTime since, LocalDateTime until, String status, Long customerId, int page, int size);
}
