package com.zoo.cryptopriceapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyDto {

    private String ipAddress;

    private String cryptoCurrencyName;

    private String unitPriceCurrencyCode;

    private double unitPrice;
}
