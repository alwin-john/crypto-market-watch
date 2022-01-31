package com.zoo.cryptopriceapi.service;

import com.zoo.cryptopriceapi.dto.SupportedCryptoCurrencyListDto;

import java.net.UnknownHostException;

public interface CryptoCurrencyService {

    SupportedCryptoCurrencyListDto getAllCryptoCurrency() throws UnknownHostException;
}
