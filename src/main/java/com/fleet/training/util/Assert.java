package com.fleet.training.util;

public class Assert
{
    public static void assertTrue(boolean expression)
    {
        if (!expression)
        {
            throw new RuntimeException("Expression is false");
        }
    }

    public static void assertFalse(boolean expression)
    {
        if (expression)
        {
            throw new RuntimeException("Expression is true");
        }
    }
}
