package com.fleet.training.misc;

public class EvaluationTest4 implements Runnable
{
    public void run()
    {
        /**
         * assumtpions:
         * numbers are contiguous
         * sequence will always start with 1
         * exactly one number is missing
         */
        //find the missing number
        int[] input_arr = {1,2,3,4};

        int n = input_arr.length + 1;
        int expectedSum = n * ( n + 1) / 2;

        int actualsum = 0;
        for(int elem : input_arr)
        {
            actualsum += elem;
        }

        System.out.println("Missing number=" + (expectedSum - actualsum));




    }
}
