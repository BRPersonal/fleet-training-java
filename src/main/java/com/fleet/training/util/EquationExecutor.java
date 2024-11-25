package com.fleet.training.util;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class EquationExecutor implements Evaluator
{
    private final List<Evaluator> evaluators;

    public EquationExecutor(List<Evaluator> evaluators)
    {
        this.evaluators = evaluators;

        //add a terminal evaluator which will print the solution
        evaluators.add(x -> {
            log.info("Following variables satisfies all equations:{}",x);
            return true;
        });

    }

    @Override
    public boolean evaluate(Map<String, Object> variables)
    {
        boolean result = false;

        for(Evaluator evaluator: evaluators)
        {
            result = evaluator.evaluate(variables);
            if(!result)
            {
                break;
            }
        }

        return result;
    }
}
