package com.fleet.training.util;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Utils
{
    public static List<String> topKFrequent(List<String> queries, int k) {
        Map<String, Integer> frequency = new HashMap<>();

        //capture frequency for each query term
        for(String query : queries) {
            frequency.merge(query, 1, Integer::sum);
        }

        //sort by freq in desc order and return first k items
        return frequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue()
                        .reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
