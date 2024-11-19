package com.fleet.training.util;

import java.util.*;

/**
 * This class is not meant to be thread-safe. Only one thread should access
 * an instance of this class at any point of time
 *
 */
public class LoopExecutor implements Iterable<Map<String,Object>>, Iterator<Map<String, Object>>
{
    private final List<LoopVariable<?>> variables;
    private List<CurrentStateIterator<?>> iterators;
    private Map<String,Object> valueMap;
    private boolean initialised;

    public LoopExecutor(List<LoopVariable<?>> variables)
    {
        this.variables = variables;

        if (variables == null || variables.isEmpty())
        {
            throw new IllegalArgumentException("variables cannot be null or empty");
        }

        valueMap = new LinkedHashMap<>();

    }


    @Override
    public Iterator<Map<String, Object>> iterator()
    {
        iterators = new ArrayList<>();

        //get fresh iterators
        for(int i = 0; i < variables.size(); i++)
        {
            iterators.add(variables.get(i).iterator());
        }

        initialised = false;
        return this;
    }

    @Override
    public boolean hasNext()
    {
        boolean hasNext = false;

        //keep returning true as long as any of the inner loops has next
        for(Iterator iter : iterators)
        {
            if (iter.hasNext())
            {
                hasNext = true;
                break;
            }
        }

        if (!initialised)
        {
            for(Iterator iter : iterators)
            {
                iter.next();
            }
            initialised = true;
        }
        else
        {
            int iterIndex = iterators.size() -1;
            while(iterIndex > 0)
            {
                if (iterators.get(iterIndex).hasNext())
                {
                    iterators.get(iterIndex).next();
                    break;
                }
                else
                {
                    iterators.remove(iterIndex);
                    iterators.add(iterIndex, variables.get(iterIndex).iterator());
                    iterators.get(iterIndex).next(); //init the iterator
                    iterIndex--;
                }
            }

            if(iterIndex == 0)
            {
                if (iterators.getFirst().hasNext())
                {
                    iterators.getFirst().next();
                }
            }
        }

        return hasNext;
    }

    @Override
    public Map<String, Object> next()
    {
        for(int i = 0; i < iterators.size(); i++)
        {
            valueMap.put(variables.get(i).getName(), iterators.get(i).current());
        }

        return valueMap;
    }
}

