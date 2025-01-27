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

        //form a map with key as salary and value as list of names
        //who are getting that same salary
        Map<Integer, List<String>> intermediateMap = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey,Collectors.toList())
                ));
        log.debug("intermediateMap={}", intermediateMap);

        //sort the map by key in descending order and
        //find out the names of employees who get the second highest salary
        Map.Entry<Integer,List<String>> entry = intermediateMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList()).get(1);

        log.debug("second highest salary={}", entry);
    }
}
