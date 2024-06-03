package com.cessadev.api_rest_udc.model.dtos;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class OrderResultDTO extends BaseResultDTO implements Serializable {

    private List<OrderDTO> orders;
    private PagingDataDTO pagingDataDTO;

    public OrderResultDTO(List<OrderDTO> orders, PagingDataDTO pagingDataDTO) {
        this.orders = orders;
        this.pagingDataDTO = pagingDataDTO;
    }

    public OrderResultDTO(String code, String message) {
        super(code, message);
    }
}
