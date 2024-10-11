package com.fleet.training.fp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Product
{
    private final ProductType type;
    private final double price;
}
