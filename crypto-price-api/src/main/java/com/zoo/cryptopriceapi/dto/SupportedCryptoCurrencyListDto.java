package com.zoo.cryptopriceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupportedCryptoCurrencyListDto {

    private String defaultIp;

    private LocalDateTime date;

    private List<CurrencyDto> currencyDtoList;
}
