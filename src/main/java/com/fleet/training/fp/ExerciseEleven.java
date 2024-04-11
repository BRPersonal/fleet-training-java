package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ExerciseEleven implements Runnable
{
    private final List<Integer> prices = Arrays.asList(10, 30, 17, 20, 18, 45, 12);

    @Override
    public void run()
    {
        double totalOfDiscountedPrices = computeDeclarative();//computeImperative();
        log.debug("Total of discounted prices(using multi-threading): {}", totalOfDiscountedPrices);
    }

    //Imperative coding
    private double computeImperative()
    {
        double totalOfDiscountedPrices = 0.0;

        for(int price : prices) {
            if(price > 20) {
                totalOfDiscountedPrices += price * 0.9;
            }
        }

        return totalOfDiscountedPrices;

    }

    //Declarative coding
    private double computeDeclarative()
    {
        return prices.parallelStream()
                .filter(price -> price > 20)
                .mapToDouble(price -> price * 0.9)
                .sum();
    }


}
