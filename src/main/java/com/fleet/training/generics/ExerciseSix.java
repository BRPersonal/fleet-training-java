package com.fleet.training.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ExerciseSix implements Runnable
{

    @Override
    public void run()
    {
        List<Integer> integers = List.of(1,2,3,4,5);
        List<Float> floats = List.of(1.0f,10.5f);
        List<Double> doubles = List.of(1.99,2.0,3.01);

        log.debug("sum of integers={}", sum(integers));
        log.debug("sum of floats={}", sum(floats));
        log.debug("sum of doubles={}", sum(doubles));

    }

    private double sum(List<? extends Number> numbers)
    {
        double sum = 0;
        for(Number n : numbers)
        {
            sum += n.doubleValue();
        }

        return sum;
    }


}
