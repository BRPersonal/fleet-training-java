package com.fleet.training.util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoopVariable<T> implements Iterable<T>
{
    private final String name;
    private final List<T> discreteValues;

    public LoopVariable(String name,List<T> discreteValues)
    {
        this.name = name;
        this.discreteValues = discreteValues;

        if (discreteValues == null || discreteValues.isEmpty())
        {
            throw new IllegalArgumentException("discreteValues cannot be null or empty");
        }
    }

    public String getName()
    {
        return name;
    }

    @Override
    public CurrentStateIterator<T> iterator()
    {
        return new CurrentStateIteratorImpl(discreteValues.iterator());
    }

    private class CurrentStateIteratorImpl implements CurrentStateIterator<T>
    {
        private final Iterator<T> target;
        private T currentState;

        private CurrentStateIteratorImpl(Iterator<T> iter)
        {
            target = iter;
        }

        @Override
        public boolean hasNext()
        {
            return target.hasNext();
        }

        @Override
        public T next()
        {
            currentState = target.next();
            return currentState;
        }

        @Override
        public T current()
        {
            return currentState;
        }
    }

    //A convenient helper method to create a range of integers
    public static List<Integer> generateIntRange(int start, int end)
    {
        return IntStream.rangeClosed(start,end)
                .boxed()
                .collect(Collectors.toList());
    }

}
