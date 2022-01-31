package com.zoo.cryptopriceapi.service;

import com.zoo.cryptopriceapi.dto.SupportedCryptoCurrencyListDto;
import com.zoo.cryptopriceapi.entity.CryptoCurrency;
import com.zoo.cryptopriceapi.exception.BusinessException;
import com.zoo.cryptopriceapi.repository.CryptoCurrencyRepository;
import com.zoo.cryptopriceapi.util.CommonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CryptoCurrencyServiceImplTest {

    @Mock
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    private CryptoCurrencyService currencyService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        currencyService = new CryptoCurrencyServiceImpl(cryptoCurrencyRepository) {
        };
    }

    @Test
    void getAllCryptoCurrency() throws UnknownHostException {
        when(cryptoCurrencyRepository.findAll()).thenReturn(getCurrencyList());
        SupportedCryptoCurrencyListDto supportedCryptoCurrencyListDto = currencyService.getAllCryptoCurrency();
        assertEquals("127.0.1.1", supportedCryptoCurrencyListDto.getDefaultIp());
    }

    @Test
    void getAllCryptoCurrencyRepoReturnNoValues() throws UnknownHostException {
        BusinessException thrown = Assertions.assertThrows(BusinessException.class, () -> {
            when(cryptoCurrencyRepository.findAll()).thenReturn(null);
            currencyService.getAllCryptoCurrency();
        }, "throwing exception while data is not available in the DB");

        Assertions.assertEquals("No data is available from database", thrown.getMessage());
    }


    private List<CryptoCurrency> getCurrencyList(){
        List<CryptoCurrency> currencies = new ArrayList<>();
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1, "127.0.0.1", "BITCOIN", "Bitcoin","USD"
                ,"&dollar", 67, CommonUtil.getCurrentTimeStamp());
        currencies.add(cryptoCurrency);
        return currencies;
    }
}