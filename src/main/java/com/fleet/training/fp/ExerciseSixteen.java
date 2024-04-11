package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ExerciseSixteen implements Runnable
{
    @Override
    public void run()
    {
        List<String> friends = List.of("Akila", "Harini", "Krithika","Mohan", "Shalini","Sneha","Vineessh");

        String names = friends.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        log.debug("Concatenated Friends List={}", names);
    }
}
