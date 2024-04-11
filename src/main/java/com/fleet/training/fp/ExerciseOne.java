package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.function.Function;

@Slf4j
public class ExerciseOne implements Runnable
{
    @Override
    public void run()
    {
        String result = process("Hello World", s -> s.toLowerCase());
        log.debug("result={}", result);
    }

    private String process(String input, Processor p)
    {
        return p.process(input);
    }

}
