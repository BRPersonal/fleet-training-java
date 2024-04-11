package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

@Slf4j
public class ExerciseSeven implements Runnable
{

    @Override
    public void run()
    {
        String[] names = {"Mr. John", "Ms tripthi", "Dr. Sanjay"};

        Arrays.sort(names , Comparator.comparing(s -> s.split(" ")[1]));
        log.debug("sorted Names={}", Arrays.toString(names));

    }
}
