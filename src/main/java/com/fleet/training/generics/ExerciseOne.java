package com.fleet.training.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseOne implements Runnable
{
    @Override
    public void run()
    {
        Box<Integer> intBox = new Box<Integer>(10);
        log.debug("item={}", intBox.getItem());

        Box<String> strBox = new Box<String>("Hello");
        log.debug("item2={}", strBox.getItem());

        //intBox = strBox;
    }
}
