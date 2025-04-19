package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ExerciseTwentyFour implements Runnable
{
    @Override
    public void run()
    {
        Map<String,Integer> map = Map.of(
                "anil",1000,
                "ankit",1200,
                "bhavna",1200,
                "james",1200,
                "michael",1000,
                "tom",1300,
                "daniel",1300);

        int n = 3;
        String suffix = "rd";
        Map.Entry<Integer,List<String>> entry = getNthTopSalariedPeople(map,n);
        log.debug("{}{} highest salary is {} . It is received by {}",
                n, suffix,entry.getKey(),entry.getValue());
    }

    private Map.Entry<Integer,List<String>> getNthTopSalariedPeople(Map<String,Integer> map, int n)
    {
        Map.Entry<Integer,List<String>> result = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                                                Collectors.mapping(Map.Entry::getKey,
                                                        Collectors.toList())
                                            )
                )
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList().get(n-1);
        return result;
    }
}
