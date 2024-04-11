package com.fleet.training.generics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Bag<T,U>
{
    private  final T first;
    private  final U second;

    public void print()
    {
        log.debug("{} {}!!", first,second);
    }
}
