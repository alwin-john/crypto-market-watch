package com.zoo.cryptopriceapi.repository;

import com.zoo.cryptopriceapi.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Integer> {

    List<CryptoCurrency> findAll();

}
