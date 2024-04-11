package com.fleet.training.generics;

public class Box<T>
{
    private final T item;

    public Box(T item)
    {
        this.item = item;
    }

    public T getItem()
    {
        return item;
    }

}
