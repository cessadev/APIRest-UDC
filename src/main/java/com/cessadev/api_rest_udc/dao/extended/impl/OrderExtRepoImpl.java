package com.cessadev.api_rest_udc.dao.extended.impl;

import com.cessadev.api_rest_udc.dao.extended.OrderExtRepo;
import com.cessadev.api_rest_udc.model.dtos.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class OrderExtRepoImpl implements OrderExtRepo {
    @Override
    public List<OrderDTO> findByFilter(int filter, String orderNumber, LocalDateTime since, LocalDateTime until, String status, Long customerId, int page, int size) {
        return null;
    }
}
