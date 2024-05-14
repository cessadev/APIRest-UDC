package com.cessadev.api_rest_udc.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingDataDTO implements Serializable {

    private int pageNumber; // Número de página
    private int pageSize; // Número de registros por página
    private int totalRows; // Número total de registros
}
