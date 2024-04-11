package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class ExerciseThree implements Runnable
{
    @Override
    public void run()
    {
        ExecutorService service = Executors.newFixedThreadPool(2);

        var f1 = service.submit(() -> log.debug("Hello"));
        Future<String> f2 = service.submit(() -> {
            Thread.sleep(500); //sleep for 500 milliseconds
            return "hello universe";
        });

        try
        {
            log.debug("f1 result={}", f1.get());
            log.debug("f2 result={}", f2.get(200, TimeUnit.MILLISECONDS)); //max timeout 200 millisec
        }
        catch(InterruptedException | ExecutionException | TimeoutException ex)
        {
            log.error("exception occured", ex);
        }
        finally
        {
            log.debug("shutting down thread pool");
            service.shutdown();
        }


    }


}
