package com.zoo.cryptopriceapi.service;

import com.zoo.cryptopriceapi.dto.CurrencyDto;
import com.zoo.cryptopriceapi.dto.SupportedCryptoCurrencyListDto;
import com.zoo.cryptopriceapi.entity.CryptoCurrency;
import com.zoo.cryptopriceapi.exception.BusinessException;
import com.zoo.cryptopriceapi.exception.BusinessExceptionReason;
import com.zoo.cryptopriceapi.repository.CryptoCurrencyRepository;
import com.zoo.cryptopriceapi.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {

    private CryptoCurrencyRepository currencyRepository;

    @Autowired
    CryptoCurrencyServiceImpl(CryptoCurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public SupportedCryptoCurrencyListDto getAllCryptoCurrency() throws UnknownHostException {

        Optional<List<CryptoCurrency>> cryptoCurrencyList = Optional.ofNullable(currencyRepository.findAll());

        if (!cryptoCurrencyList.isPresent()) {
            throw new BusinessException(BusinessExceptionReason.NOT_FOUND, "No currency is available at the moment");
        }
        List<CurrencyDto> currencies = cryptoCurrencyList.get().stream()
                .map(c -> new CurrencyDto(c.getIpAddress(), c.getCurrency()
                        , c.getUnitPriceCurrencyCode(), c.getUnitPrice())).collect(Collectors.toList());

        String ip = InetAddress.getLocalHost().getHostAddress();
        log.debug("current IP of the system ", ip);
        return new SupportedCryptoCurrencyListDto(ip, CommonUtil.getCurrentTimeStamp(), currencies);
    }
}
