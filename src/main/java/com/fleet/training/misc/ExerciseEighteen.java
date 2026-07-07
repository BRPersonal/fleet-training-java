package com.fleet.training.misc;

import com.fleet.training.util.TTLCache;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseEighteen implements Runnable
{
    @Override
    public void run()
    {
        TTLCache<String,Float> cache = new TTLCache<>(5000);
        cache.put("Balaji", 100.0f);
        log.debug("Balaji has {} ", cache.get("Balaji"));
        log.debug("Sleeping for 5 seconds");
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        log.debug("Balaji has {} ", cache.get("Balaji"));
    }

}
