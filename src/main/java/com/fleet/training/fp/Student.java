package com.fleet.training.fp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Student
{
    private final String name;
    private final int age;
}
