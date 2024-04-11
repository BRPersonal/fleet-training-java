package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
public class ExerciseFifteen implements Runnable
{
    @Override
    public void run()
    {
        List<String> friends = List.of("Akila", "Harini", "Krithika","Mohan", "Shalini","Sneha","Vineessh");

        System.out.print("Enter Length:");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();


        Optional<String> matchingName = friends.stream()
                .filter(e1 -> e1.length() == length)
                .findFirst();

        matchingName.ifPresent(name -> log.debug("matching Name={}",name));

        //String alternateName = matchingName.orElse(getDefaultName());
        String alternateName = matchingName.orElseGet(() ->getDefaultName());
        log.debug("alternateName={}", alternateName);

    }

    private String getDefaultName()
    {
        log.debug("Executing getDefaultName method");
        return "No Name Found";
    }

}
