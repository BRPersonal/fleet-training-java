package com.fleet.training.fp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StockData
{
    private final String ticker;
    private final double price;
}
