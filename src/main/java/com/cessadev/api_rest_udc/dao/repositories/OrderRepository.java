package com.cessadev.api_rest_udc.dao.repositories;

import com.cessadev.api_rest_udc.dao.extended.OrderExtRepo;
import com.cessadev.api_rest_udc.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderExtRepo {
    Optional<Order> findByOrderNumber(String orderNumber);
}
