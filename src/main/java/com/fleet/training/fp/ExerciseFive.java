package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;

@Slf4j
public class ExerciseFive implements Runnable
{
    @Override
    public void run()
    {
        String result = process("Hello World", 5,String::substring);
        log.debug("result={}", result);
    }

    private String process(String input, int index, BiFunction<String, Integer,String> processor)
    {
        return processor.apply(input,index);
    }
}
