package com.fleet.training.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

//CyclicBarrier example
@Slf4j
public class ExerciseFour implements Runnable
{
    private static class Worker implements Runnable
    {
        private final CyclicBarrier barrier;
        private final AtomicInteger counter;

        Worker(CyclicBarrier barrier,AtomicInteger counter)
        {
            this.barrier = barrier;
            this.counter = counter;
        }

        @Override
        public void run()
        {
            log.debug(" is working...");
            try
            {
                Thread.sleep(1000 + new Random().nextInt(500)+1); // Simulating work
                int token = counter.incrementAndGet();
                log.debug("reached the barrier with token:{}", token);
                barrier.await(); // Wait at the barrier
                log.debug(" passed the barrier!");
            }
            catch (InterruptedException | BrokenBarrierException e)
            {
                log.error("Interrupted or Barrier Broken");
            }
        }
    }

    @Override
    public void run()
    {
        int numThreads = 3;

        //Note: barrier action will run in the thread that last calls the barrier.await() method
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> log.debug("All threads reached the barrier!"));
        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < numThreads; i++)
        {
            Thread worker = new Thread(new Worker(barrier,counter));
            worker.setName("Worker-" + i);
            worker.start();
        }
    }
}


