package com.fleet.training.util;

import java.util.Map;

@FunctionalInterface
public interface Evaluator
{
    boolean evaluate(Map<String, Object> variables);
}
