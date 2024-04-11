package com.fleet.training.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CalculatorJUnit5Test
{

    @BeforeEach
    void printBefore()
    {
        log.debug("========================================");
    }

    @AfterEach
    void printAfter()
    {
        log.debug("########################################");
    }


    @DisplayName("Add Max Integer")
    @Test
    public void testAddMaxInteger()
    {
        int actualResult = 2147483646;
        Integer expected = Integer.sum(2147183646, 300000);
        log.debug("sum={}", actualResult);
        assertThat(actualResult).as("sum should match").isEqualTo(expected);
    }

    @DisplayName("Divide by zero")
    @Test
    public void testDivide()
    {
        int numerator = 42;
        int denominator = 0;

        log.debug("Dividing {} / {}", numerator,denominator);
        assertThrows(ArithmeticException.class, () -> Integer.divideUnsigned(numerator, denominator));
    }
}
