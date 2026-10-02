package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
public class ExerciseTwentySix implements Runnable
{
    @Override
    public void run()
    {
        ProductV2 product1 = newProduct("Inside Java", "Java book", new BigDecimal("29.99"),ProductTypeV2.BOOK);
        ProductV2 product2 = newProductFp("Transcend16Gb", "Memory card", new BigDecimal("9.99"),ProductTypeV2.ELECTRONIC);

        log.debug("product1={}", product1);
        log.debug("product2={}", product2);
    }

    private static ProductV2 newProduct (String name, String description,
                                         BigDecimal price, ProductTypeV2 productType)
    {
        Objects.requireNonNull(name, "Name is null");
        Objects.requireNonNull(description, "description is null");
        Objects.requireNonNull(price, "price is null");

        return switch (productType)
        {
            case BOOK -> new BookProduct(name, description, price);
            case ELECTRONIC -> new ElectronicProduct(name, description, price);
            case FASHION -> new FashionProduct(name, description, price);
        };
    }

    private static ProductV2 newProductFp(String name, String description,
                                          BigDecimal price, ProductTypeV2 productType)
    {
        return productType.newInstance(name,description,price);
    }
}
