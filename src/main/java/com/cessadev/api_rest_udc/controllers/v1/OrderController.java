package com.cessadev.api_rest_udc.controllers.v1;

import com.cessadev.api_rest_udc.model.dtos.OrderResultDTO;
import com.cessadev.api_rest_udc.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orders_v1")
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/by-filter")
    public ResponseEntity<OrderResultDTO> byFilter(
        @RequestParam(name = "filter", defaultValue = "0") int filter,
        @RequestParam(name = "order_number", required = false) String orderNumber,
        @RequestParam(name = "since", required = false) String since,
        @RequestParam(name = "until", required = false) String until,
        @RequestParam(name = "status", required = false) String status,
        @RequestParam(name = "customer_email") String customerEmail,
        @RequestParam(name = "page_number", defaultValue = "0") int pageNumber,
        @RequestParam(name = "page_size", defaultValue = "50") int pageSize
    ) {
        try {
            OrderResultDTO orderResultDTO = orderService.getOrdersByFilter(
                    filter, orderNumber, since, until, status, customerEmail, pageNumber, pageSize
            );
            return ResponseEntity.ok(orderResultDTO);
        } catch (RuntimeException exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
