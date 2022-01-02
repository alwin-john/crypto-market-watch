CREATE TABLE CRYPTO_CURRENCY_INFO(
    id INT NOT NULL,
    ip_address VARCHAR(15) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    description VARCHAR(15),
    unit_price_currency VARCHAR(10) NOT NULL,
    unit_price_currency_code VARCHAR(10) NOT NULL,
    unit_price FLOAT NOT NULL,
    updated_date TIMESTAMP
);