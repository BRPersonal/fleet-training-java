package com.fleet.training.misc;

public class PrimeFinder
{
    public static int findNthPrime(int n)
    {
        int count = 0;
        int num = 1;

        while (count < n)
        {
            num++;
            if (isPrime(num))
            {
                count++;
            }

        }

        return num;
    }

    private static boolean isPrime(int n)
    {
        if (n < 2)
        {
            return false;
        }
        else
        {
            for(int i = 2; i < n; i++)
            {
                if (n % i == 0)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
