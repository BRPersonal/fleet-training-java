package com.fleet.training.fp;

import java.util.HashMap;
import java.util.Map;

public class DummyStockPriceFetcher implements IStockPriceFetcher
{
    private final Map<String, String> fakePrices;
    
    public DummyStockPriceFetcher()
    {
        fakePrices = new HashMap<>();
        fakePrices.put("AMD", "81"); fakePrices.put("HPQ", "33"); fakePrices.put("IBM", "135");
        fakePrices.put("TXN", "150"); fakePrices.put("VMW", "116"); fakePrices.put("XRX", "15");
        fakePrices.put("AAPL", "131"); fakePrices.put("ADBE", "360"); fakePrices.put("AMZN", "106");
        fakePrices.put("CRAY", "130"); fakePrices.put("CSCO", "43"); fakePrices.put("SNE", "72");
        fakePrices.put("GOOG", "2157"); fakePrices.put("INTC", "36"); fakePrices.put("INTU", "369");
        fakePrices.put("MSFT", "247"); fakePrices.put("ORCL", "67"); fakePrices.put("TIBX", "24");
        fakePrices.put("VRSN", "157"); fakePrices.put("RIVN", "26");
    }
    
    @Override
    public StockData getPrice(String ticker)
    {
        //simulate a small delay to mimic a webservice call across the network
        try
        {
            Thread.sleep(200);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        String price = fakePrices.get(ticker);

        if (price != null)
        {
            return new StockData(ticker,Double.parseDouble(price));
        }
        else
        {
            throw new IllegalArgumentException("Invalid ticker:" + ticker);
        }

    }
}
