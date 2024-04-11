package com.fleet.training.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

/**
 * Demonstrates how Optional usage can avoid NullPointerException
 */

@Slf4j
public class ExerciseThree implements Runnable
{
    
    @Override
    public void run()
    {
        String[] names = {"balaji","dhamo",null,"sathish","raja"};
        int totalLength = Arrays.stream(names)
                .map(name -> Optional.ofNullable(name))
                .filter(Optional::isPresent) //skip nulls
                .mapToInt(o1 -> o1.get().length())
                .sum();

        log.debug("totalLength={}", totalLength);

    }
}
