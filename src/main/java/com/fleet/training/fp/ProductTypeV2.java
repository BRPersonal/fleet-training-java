package com.fleet.training.fp;

import java.math.BigDecimal;
import java.util.Objects;

public enum ProductTypeV2
{
    ELECTRONIC(ElectronicProduct::new),
    FASHION(FashionProduct::new),
    BOOK(BookProduct::new);

    private final TriFunction<String, String, BigDecimal, ProductV2> factory;

    ProductTypeV2 (TriFunction<String, String, BigDecimal, ProductV2> factory)
    {
        this.factory = factory;
    }

    public ProductV2 newInstance (String name, String description, BigDecimal price)
    {
        Objects.requireNonNull(name, "Name is null");
        Objects.requireNonNull(description, "description is null");
        Objects.requireNonNull(price, "price is null");

        return factory.apply(name,description,price);
    }
}
