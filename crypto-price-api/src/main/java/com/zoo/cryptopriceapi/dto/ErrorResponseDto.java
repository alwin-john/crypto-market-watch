package com.zoo.cryptopriceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {

    private String code;

    private String message;

    private Integer status;

    private LocalDateTime timestamp;
}
