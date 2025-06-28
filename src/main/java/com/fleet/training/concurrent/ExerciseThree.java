package com.fleet.training.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ExerciseThree implements Runnable
{
    @Override
    public void run()
    {
        //ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicCounter counter = new AtomicCounter();

        // Submit 1000 increment tasks
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        log.debug("Final count={}", counter.get()); //This will vary for each run
    }

    private static class AtomicCounter
    {
        private final AtomicInteger counter = new AtomicInteger(0);

        public void increment()
        {
            counter.incrementAndGet();
        }

        public int get()
        {
            return counter.get();
        }
    }
}
