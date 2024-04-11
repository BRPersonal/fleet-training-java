package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ExerciseTwo implements Runnable
{
    @Override
    public void run()
    {
        System.out.print("Enter Number:");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        log.debug("Number of unique digits in {} is {}", number, countUniqueDigits(number));


    }

    private int countUniqueDigits(int number)
    {
        int mask = 0;
        number = Math.abs(number);

        while(number > 0)
        {
            int digit = number % 10;
            mask = mask | (1 << digit);
            number = number / 10;
        }
        return Integer.bitCount(mask);
    }
}
