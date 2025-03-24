package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EvaluationTest3 implements Runnable
{
    public void run()
    {
        //swap two string variables without using temp variable
        String s1 = "Hello";
        String s2 = "Universe";

        s1 = s1 + s2;
        s2 = s1.substring(0,s1.length() - s2.length());
        s1 = s1.substring(s2.length());

        log.debug("s1={},s2={}",s1,s2);
    }
}
