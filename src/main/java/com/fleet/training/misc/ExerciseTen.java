package com.fleet.training.misc;

import com.fleet.training.util.LoopExecutor;
import com.fleet.training.util.LoopVariable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class ExerciseTen  implements Runnable
{
    @Override
    public void run()
    {
        LoopVariable<Integer> x1 = new LoopVariable<>("x1", LoopVariable.generateIntRange(1, 8));
        LoopVariable<Integer> y1 = new LoopVariable<>("y1", LoopVariable.generateIntRange(1, 8));
        LoopVariable<Integer> z1 = new LoopVariable<>("z1", LoopVariable.generateIntRange(1, 8));

        LoopVariable<Integer> x2 = new LoopVariable<>("x2", LoopVariable.generateIntRange(1, 8));
        LoopVariable<Integer> y2 = new LoopVariable<>("y2", LoopVariable.generateIntRange(1, 8));
        LoopVariable<Integer> z2 = new LoopVariable<>("z2", LoopVariable.generateIntRange(1, 8));

        LoopVariable<Integer> x3 = new LoopVariable<>("x3", LoopVariable.generateIntRange(1, 8));
        LoopVariable<Integer> y3 = new LoopVariable<>("y3", LoopVariable.generateIntRange(1, 8));
        LoopVariable<Integer> z3 = new LoopVariable<>("z3", LoopVariable.generateIntRange(1, 8));

        LoopExecutor loopExecutor = new LoopExecutor(List.of(x1,y1,z1,x2,y2,z2,x3,y3,z3));
        int i = 0;
        long counter = 0;
        for (Map<String, Object> step : loopExecutor)
        {
            i++;
            counter++;

            if ( i % 1000 == 0)
            {
                log.debug("{}",step);
                i = 0;
            }
        }
        log.debug("End of Iterations. Total count={}", counter);


    }
}
