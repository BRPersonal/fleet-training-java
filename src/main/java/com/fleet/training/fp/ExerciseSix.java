package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ExerciseSix implements Runnable
{

    @Override
    public void run()
    {
        String[] names = {"Mr. John", "Ms tripthi", "Dr. Sanjay"};

        Arrays.sort(names , (s1,s2) -> s1.split(" ")[1].compareTo(s2.split(" ")[1]));
        log.debug("sorted Names={}", Arrays.toString(names));
    }
}
