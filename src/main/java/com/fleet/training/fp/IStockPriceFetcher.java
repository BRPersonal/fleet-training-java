package com.fleet.training.fp;

public interface IStockPriceFetcher
{
    StockData getPrice(String ticker);
}
