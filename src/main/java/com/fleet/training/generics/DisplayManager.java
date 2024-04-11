package com.fleet.training.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisplayManager
{
    public static <T> void display(T element)
    {
       log.debug("{} = {}", element.getClass().getName(), element);
    }
}
