package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This is debugging exercise given to trainees
 */

@Slf4j
public class ExerciseSeventeen implements Runnable
{
    private final Function<String, Predicate<String>> startsWithLetter;

    public ExerciseSeventeen()
    {
        startsWithLetter = a -> b -> a.startsWith(b);
    }

    @Override
    public void run()
    {
        List<String> friends = List.of("Akila", "Harini", "Krithika","Mohan", "Shalini","Sneha","Vineessh");

        log.debug("Invoking logCount methods...");

        logCount(friends,"S");
        logCount(friends,"B");

    }

    private void logCount(List<String> friends, String startingLetter)
    {
        long count = friends.stream().filter(startsWithLetter.apply(startingLetter)).count();
        log.debug("count of names starting with letter {}={}", startingLetter,count);
    }
}
