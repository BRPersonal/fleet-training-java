package com.fleet.training.generics;

public class ExerciseThree implements Runnable
{
    @Override
    public void run()
    {
        DisplayManager.display(11);
        DisplayManager.display("I am a Java Buff");
        DisplayManager.display(1.0f);
        DisplayManager.display(10.0);
    }
}
