package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * This is coding exercise to trainees
 */

@Slf4j
public class ExerciseEighteen implements Runnable
{
    private static final List<String> symbols = Arrays.asList(
            "AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL","ADBE",
            "AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU",
            "MSFT", "ORCL", "TIBX", "VRSN", "RIVN");

    @Override
    public void run()
    {

        IStockPriceFetcher fetcher = new DummyStockPriceFetcher();

        //find highest priced stock less than 500
        StockData highestPricedStock = symbols.parallelStream()
                .map(fetcher::getPrice)
                .filter(isPriceLessThan(500))
                .reduce(this::pickHigh).get();

        log.debug("ticker={}, price={}", highestPricedStock.getTicker(), highestPricedStock.getPrice());
    }

    private Predicate<StockData> isPriceLessThan(double price)
    {
        return s -> s.getPrice() < price;
    }

    private StockData pickHigh(StockData first, StockData second)
    {
        return first.getPrice() > second.getPrice() ? first : second;
    }


}
