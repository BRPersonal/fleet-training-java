package com.fleet.training.fp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Person
{
    private final String name;
    private final int age;

    public int getAgeDifference(Person another)
    {
        return age - another.age;
    }
}
