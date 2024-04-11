package com.fleet.training.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class ExerciseOne implements Runnable
{
    @Override
    public void run()
    {
        String name = null;
        log.debug("length={}", Optional.ofNullable(name).map(String::length).orElse(0));
    }
}
