package com.cessadev.api_rest_udc.model.dtos;

public record CustomerDTO(
        long id,
        String name,
        String email,
        String phone
) {
}
