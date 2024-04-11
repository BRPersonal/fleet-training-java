package com.fleet.training.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;


public class GenericsTest
{
    @DisplayName("test generics")
    @Test
    public void testArrayOfIntegers()
    {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList = fromArrayToList(intArray,Object::toString);
        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }

    private <T, G> List<G> fromArrayToList(T[] arr, Function<T, G> mapperFunction)
    {
        return Arrays.stream(arr)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

}
