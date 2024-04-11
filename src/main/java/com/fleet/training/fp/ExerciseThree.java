package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class ExerciseThree implements Runnable
{
    @Override
    public void run()
    {
        String result = process("Hello World", String::toLowerCase);
        log.debug("result={}", result);
    }

    private String process(String input, Function<String, String> processor)
    {
        return processor.apply(input);
    }

}
