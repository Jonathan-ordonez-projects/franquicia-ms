package com.api.franquicia.services.dto;

import lombok.*;

import java.io.Serializable;
@Data
@Builder
public class ErrorDto {

    private String code;
    private String message;
}
