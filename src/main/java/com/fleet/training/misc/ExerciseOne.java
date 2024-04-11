package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseOne implements Runnable
{
    @Override
    public void run()
    {
        int n = 1000;

        int nthPrime = PrimeFinder.findNthPrime(n);

        log.debug("{} th prime number is {}", n,nthPrime);

        int iterations = 100;

        long start = System.nanoTime();
        for(int i = 0; i < iterations; i++)
        {
            PrimeFinder.findNthPrime(n);
        }
        long end = System.nanoTime();
        double durationInMicros = (end - start) / 1000d; //convert to micro seconds

        double averageTimePerIteration = durationInMicros / (iterations * 1000d); //convert to milli seconds
        log.debug("Time taken using Java prime finder:{} milliseconds per iteration", averageTimePerIteration);


    }


}
