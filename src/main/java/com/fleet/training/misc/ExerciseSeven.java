package com.fleet.training.misc;

import com.fleet.training.util.CurrentStateIterator;
import com.fleet.training.util.LoopVariable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ExerciseSeven implements Runnable
{
    @Override
    public void run()
    {
        LoopVariable<Integer> x = new LoopVariable<>("X", LoopVariable.generateIntRange(1, 10));
        LoopVariable<String> y = new LoopVariable<>("Y", List.of("Apple","Banana","Orange"));
        enumerate(List.of(x,y));

    }

    private void enumerate(List<LoopVariable<?>> variables)
    {
        for(LoopVariable<?> variable: variables)
        {
            enumerate(variable);
        }
    }

    private void enumerate(LoopVariable<?> x)
    {
        for(int i = 0; i < 2 ; i++)
        {
            System.out.printf("Iteration %d%n",(i+1));
            System.out.println("-----------------");

            for (Object item : x)
            {
                System.out.println(item);
            }
        }

        //Let us demonstrate using CurrentStateIterator
        for(int i = 2; i < 4; i++)
        {
            System.out.printf("Iteration %d%n",(i+1));
            System.out.println("-----------------");

            for(CurrentStateIterator<?> iter = x.iterator(); iter.hasNext();)
            {
                Object item = iter.next();
                Object curr = iter.current();
                System.out.println(item + "/" + curr);
            }

        }
    }
}
