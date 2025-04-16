package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseFifteen implements Runnable
{
    @Override
    public void run()
    {
        OrderStatus status = OrderStatus.getInitialState();
        while(!status.isTerminalState())
        {
            log.debug("Transitioning to {}", status);
            status = status.next();
        }
        log.debug("Reached final state {}", status);
    }
}
