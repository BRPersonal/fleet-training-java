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
public class ExerciseNine implements Runnable
{
    @Override
    public void run()
    {
        Evaluator equation1 = variables -> {
              //4x-3y = -1
              int varX = (Integer)variables.get("x");
              int varY = (Integer)variables.get("y");
              return 4 * varX - 3 * varY == -1;
        };

        Evaluator equation2 = variables -> {
            //3x+2y=29
            int varX = (Integer)variables.get("x");
            int varY = (Integer)variables.get("y");
            return 3 * varX + 2 * varY == 29;
        };

        List<Evaluator> evaluators = new ArrayList<>();
        evaluators.add(equation1);
        evaluators.add(equation2);
        EquationExecutor eqExecutor = new EquationExecutor(evaluators);

        LoopVariable<Integer> x = new LoopVariable<>("x", LoopVariable.generateIntRange(1, 9));
        LoopVariable<Integer> y = new LoopVariable<>("y", LoopVariable.generateIntRange(1, 9));
        LoopExecutor loopExecutor = new LoopExecutor(List.of(x,y));

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
