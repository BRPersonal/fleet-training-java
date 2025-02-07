package com.fleet.training.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ExerciseFourteen implements Runnable
{
    @Override
    public void run()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number:");
        int n = in.nextInt();
        in.nextLine();  //consume a carriage return
        boolean result = isPalindrome(n);
        log.debug("result={}", result);
    }

    private boolean isPalindrome(int n)
    {
        boolean result = true;
        int digitCount = getNoOfDigits(n);
        log.debug("digitCount={}", digitCount);

        while(digitCount > 1)
        {
            int leftMostDigit = n / (int)Math.pow(10,digitCount - 1);
            int rightMostDigit = (n  % 10);
            log.debug("leftMostDigit={}, rightMostDigit={}",leftMostDigit , rightMostDigit);
            if (leftMostDigit != rightMostDigit)
            {
                result = false;
                break;
            }

            //discard leftmost and rightmost digits
            n = (n - leftMostDigit * (int)Math.pow(10,digitCount - 1) ) / 10;
            digitCount -= 2;
            log.debug("n={}, digitCount={}",n,digitCount);


        }
        return result;

    }

    private int getNoOfDigits(int n)
    {
        int digits = 1;
        for(; n / 10 > 0; digits++,n /= 10);
        return digits;
    }
}
