package com.cessadev.api_rest_udc.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResultDTO implements Serializable {

    private String code = "0";
    private String message = "";
}
