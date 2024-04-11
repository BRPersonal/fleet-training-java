package com.fleet.training.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ExerciseOne implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            ExecutorService executor = Executors.newCachedThreadPool();
            //Future<String> future = calculateAsync(executor);
            Future<String> future = doHelloWorld();

            log.debug("I Got Future. Invoking a get is going to block");
            log.debug("result={}", future.get());

            //If this is not called , jvm will keep running
            //doGracefulShutdown(executor);

        }
        catch(Exception ex)
        {
            log.error("Interrupted ", ex);
        }


    }

    private Future<String> calculateAsync(ExecutorService executor)
    {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executor.submit(() -> {
            try
            {
                Thread.sleep(1000); //sleep a second
            }
            catch(InterruptedException ex)
            {
                log.error("Interrupted ", ex);
                Thread.currentThread().interrupt();
            }
            log.debug("Completing the task...");
            completableFuture.complete("Hello");

        });

        return completableFuture;
    }

    private Future<String> doHelloWorld()
    {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> " World"), (s1, s2) -> s1 + s2);

        completableFuture.complete("Hello");  //has no effect
        return completableFuture;
    }

    private void doGracefulShutdown(ExecutorService executor)
    {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS))
            {
                executor.shutdownNow();
            }
        }
        catch (InterruptedException ex)
        {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
