package com.fleet.training.generics;

import static com.fleet.training.generics.GenericArraySorter.sort;

public class ExerciseFour implements Runnable
{
    @Override
    public void run()
    {
        Integer[] a = { 100, 22, 58, 41, 6, 50 };
        Character[] c = { 'j', 'a', 'v', 'a', 'd', 'e', 'v' };
        String[] s = { "Virat", "Rohit", "Abhinay", "Chandu","Sam", "Bharat", "Kalam" };

        sort(a);
        sort(c);
        sort(s);

    }
}
