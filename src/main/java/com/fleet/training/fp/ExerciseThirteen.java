package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class ExerciseThirteen implements Runnable
{
    @Override
    public void run()
    {
        List<String> friends = List.of("Akila", "Harini", "Krithika","Mohan", "Shalini","Sneha","Vineessh");

        //find the first longest matching name from the list
        Optional<String> matchingName = friends.stream()
                                       .reduce((e1,e2) -> e1.length() >= e2.length() ? e1 : e2);

        matchingName.ifPresent(name -> log.debug("matching Name={}",name));

    }

}
