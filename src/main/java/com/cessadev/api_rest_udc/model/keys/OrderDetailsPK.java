package com.cessadev.api_rest_udc.model.keys;

import com.cessadev.api_rest_udc.model.entities.Order;
import com.cessadev.api_rest_udc.model.entities.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailsPK implements Serializable {

    private Order order;
    private Product product;
}
