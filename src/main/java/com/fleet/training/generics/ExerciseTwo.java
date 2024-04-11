package com.fleet.training.generics;

public class ExerciseTwo implements Runnable
{
    @Override
    public void run()
    {
        Bag<String,Integer> giftBag = new Bag<String,Integer>("Warm Welcome To",2024);
        giftBag.print();
    }
}
