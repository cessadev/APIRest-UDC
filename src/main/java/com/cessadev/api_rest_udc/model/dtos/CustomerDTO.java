package com.cessadev.api_rest_udc.model.dtos;

import com.cessadev.api_rest_udc.model.entities.Customer;

public record CustomerDTO(
        long id,
        String name,
        String email,
        String phone
) {
    public static CustomerDTO from(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
}
