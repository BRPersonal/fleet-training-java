package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class ExerciseTwelve implements Runnable
{
    private final Function<Integer, Predicate<String>> checkLength;

    public ExerciseTwelve()
    {
        checkLength = length -> name -> name.length() >= length;
        log.debug("className of checkLength={}", checkLength.getClass().getName());
    }

    @Override
    public void run()
    {
        List<String> friends = List.of("Akila", "Harini", "Krithika","Mohan", "Shalini","Sneha","Vineessh");

        log.debug("Invoking logCount methods...");

        logCount(friends,5);
        logCount(friends,6);
        logCount(friends,8);
        logCount(friends,10);

    }

    private void logCount(List<String> friends, int thresHold)
    {
        long count = friends.stream().filter(checkLength.apply(thresHold)).count();
        log.debug("count of names whose length >= {}={}", thresHold,count);
    }


}
