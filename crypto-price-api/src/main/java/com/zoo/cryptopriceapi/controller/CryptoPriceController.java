package com.zoo.cryptopriceapi.controller;


import com.zoo.cryptopriceapi.dto.SupportedCryptoCurrencyListDto;
import com.zoo.cryptopriceapi.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/crypto/api/v1")
public class CryptoPriceController {

    private CryptoCurrencyService cryptoCurrencyService;

    @Autowired
    CryptoPriceController(CryptoCurrencyService cryptoCurrencyService) {
        this.cryptoCurrencyService = cryptoCurrencyService;
    }

    @GetMapping("/currency-rates")
    public ResponseEntity<SupportedCryptoCurrencyListDto> getEcbReferenceRateOfCurrencyPair() throws UnknownHostException {
        return new ResponseEntity<>(this.cryptoCurrencyService.getAllCryptoCurrency(), HttpStatus.OK);
    }

}
