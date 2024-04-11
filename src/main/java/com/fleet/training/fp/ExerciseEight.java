package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class ExerciseEight implements Runnable
{
    @Override
    public void run()
    {
        String[] names = {"Mr. John", "Ms tripthi", "Dr. Sanjay"};

        Arrays.sort(names , Comparator.comparing(this::extractFirstName));
        log.debug("sorted Names={}", Arrays.toString(names));

    }

    private String extractFirstName(String s)
    {
        return s.split(" ")[1];
    }
}
