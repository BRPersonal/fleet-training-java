package com.fleet.training.misc;

import com.fleet.training.util.EquationExecutor;
import com.fleet.training.util.Evaluator;
import com.fleet.training.util.LoopExecutor;
import com.fleet.training.util.LoopVariable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExerciseEleven implements Runnable
{
    @Override
    public void run()
    {
        Evaluator equation1 = variables -> {
            //x != y != z
            int x = (Integer)variables.get("x");
            int y = (Integer)variables.get("y");
            int z = (Integer)variables.get("z");

            return (x != y) && (y != z) && (x != z);
        };

        Evaluator equation2 = variables -> {
            //x + y + z = 100
            int x = (Integer)variables.get("x");
            int y = (Integer)variables.get("y");
            int z = (Integer)variables.get("z");
            return (x+y+z) == 100;
        };

        List<Evaluator> evaluators = new ArrayList<>();
        evaluators.add(equation1);
        evaluators.add(equation2);
        EquationExecutor eqExecutor = new EquationExecutor(evaluators);

        LoopVariable<Integer> x = new LoopVariable<>("x", List.of(13,57,8,39,48,24,47));
        LoopVariable<Integer> y = new LoopVariable<>("y", List.of(13,57,8,39,48,24,47));
        LoopVariable<Integer> z = new LoopVariable<>("z", List.of(13,57,8,39,48,24,47));

        LoopExecutor loopExecutor = new LoopExecutor(List.of(x,y,z));

        boolean atleastOneSolutionExists = false;

        for (Map<String, Object> step : loopExecutor)
        {
            boolean result = eqExecutor.evaluate(step);
            if (result)
            {
                atleastOneSolutionExists = true;
            }
        }

        if (!atleastOneSolutionExists)
        {
            log.debug("No solutions found");
        }
    }
}
