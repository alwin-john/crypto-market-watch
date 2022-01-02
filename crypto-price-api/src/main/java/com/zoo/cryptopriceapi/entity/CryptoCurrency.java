package com.zoo.cryptopriceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CRYPTO_CURRENCY_INFO")
public class CryptoCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "currency")
    private String currency;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price_currency")
    private String unitPriceCurrency;

    @Column(name = "unit_price_currency_code")
    private String unitPriceCurrencyCode;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;


}
