package com.fleet.training.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BinaryOperator;

/**
 * This is coding exercise to trainees
 */

@Slf4j
public class ExerciseFourteen implements Runnable
{
    private static final int FIRST_LONGEST = 1;
    private static final int LAST_LONGEST = 2;
    private static final int FIRST_SHORTEST = 3;
    private static final int LAST_SHORTEST = 4;

    @Override
    public void run()
    {
        List<String> friends = List.of("Akila", "Harini", "Krithika","Mohan", "Shalini","Sneha","Vineessh");

        System.out.print("Enter Numeric Option(1. First Longest 2.Last Longest 3.First Shortest 4.Last Shortest ):");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        Optional<String> matchingName = friends.stream()
                .reduce(getReductionExpression(option));

        matchingName.ifPresent(name -> log.debug("matching Name={}",name));

    }

    private BinaryOperator<String> getReductionExpression(int expressionId)
    {
        BinaryOperator<String> operator = null;

        switch (expressionId)
        {
            case FIRST_LONGEST:
                operator = (e1,e2) -> e1.length() >= e2.length() ? e1 : e2;
                break;

            case LAST_LONGEST:
                operator = (e1,e2) -> e2.length() >= e1.length() ? e2 : e1;
                break;

            case FIRST_SHORTEST:
                operator = (e1,e2) -> e1.length() <= e2.length() ? e1 : e2;
                break;

            case LAST_SHORTEST:
                operator = (e1,e2) -> e2.length() <= e1.length() ? e2 : e1;
                break;
        }
        return operator;
    }

}
