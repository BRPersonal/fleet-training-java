package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class EvaluationTest implements Runnable
{
    public void run()
    {
        List<String> words = new ArrayList<>(List.of("abc12", "ab3c4", "12abc", "def12", "1234","5678a"));
        Set<NumberAgnosticToken> result = new LinkedHashSet<NumberAgnosticToken>();
        for (String word : words) {
            result.add(new NumberAgnosticToken(word));
        }
        log.debug("result={}", result);
    }

}
