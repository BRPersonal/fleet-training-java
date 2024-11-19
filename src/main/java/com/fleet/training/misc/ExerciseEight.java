package com.fleet.training.misc;

import com.fleet.training.util.LoopExecutor;
import com.fleet.training.util.LoopVariable;

import java.util.List;
import java.util.Map;

public class ExerciseEight  implements Runnable
{
    @Override
    public void run()
    {
        LoopVariable<Integer> x = new LoopVariable<>("quantity", LoopVariable.generateIntRange(1, 10));
        LoopVariable<String> y = new LoopVariable<>("fruit", List.of("Apple","Banana","Orange"));
        LoopVariable<Float> z = new LoopVariable<>("price", List.of(1.99f,2.99f,3.99f));

        LoopExecutor executor = new LoopExecutor(List.of(x,y,z));

        for(Map<String,Object> step : executor)
        {
            System.out.println(step);
        }
    }
}
