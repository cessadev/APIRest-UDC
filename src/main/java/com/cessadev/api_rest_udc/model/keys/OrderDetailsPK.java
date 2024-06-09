package com.cessadev.api_rest_udc.model.keys;

import com.cessadev.api_rest_udc.model.entities.Order;
import com.cessadev.api_rest_udc.model.entities.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailsPK implements Serializable {

    private Order order;
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailsPK that = (OrderDetailsPK) o;

        if (!order.equals(that.order)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = order.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }
}
