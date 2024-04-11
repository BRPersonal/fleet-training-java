package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ExerciseNine implements Runnable
{
    @Override
    public void run()
    {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(this::print);
    }

    private void print(String s)
    {
        log.debug("feature={}", s);
    }
}
