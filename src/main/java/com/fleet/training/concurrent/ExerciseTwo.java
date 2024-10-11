package com.fleet.training.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import static java.util.concurrent.StructuredTaskScope.*;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ExerciseTwo implements Runnable
{
    @Override
    public void run()
    {
        try (var scope = new ShutdownOnFailure())
        {
            //submit task within structured scope
            Subtask<Integer> future1 = scope.fork(() -> {
                Thread.currentThread().setName("Custom-Task-Thread-1"); //setting it because this is coming as blank
                log.debug("Task 1 running...");
                Thread.sleep(1000); //simulate 1 sec delay
                return 10;
            });

            Subtask<Integer> future2 = scope.fork(() -> {
                Thread.currentThread().setName("Custom-Task-Thread-2"); //setting it because this is coming as blank
                log.debug("Task 2 running...");
                Thread.sleep(3000); //simulate 3 sec delay
                return 20;
            });

            //wait for all tasks to complete with a deadline of 5 seconds
            Instant deadLine = Instant.now().plus(Duration.ofSeconds(5));
            scope.joinUntil(deadLine);
            scope.throwIfFailed();
            int result = future1.get() + future2.get();
            log.debug("Result={}", result);

            //No need for shutdown code. resources are cleaned automatically
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted",ex);
        }
        catch(TimeoutException ex)
        {
            log.error("Thread timed-out",ex);
            throw new RuntimeException(ex);
        }
        catch (ExecutionException ex)
        {
            log.error("Thread execution error", ex);
            throw new RuntimeException(ex);
        }

    }
}
