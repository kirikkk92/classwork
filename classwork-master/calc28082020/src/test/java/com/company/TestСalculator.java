package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestСalculator {

    Calculator calculator;

    @BeforeEach
    public void before() {
         calculator = new Calculator();
    }

    @Test
    public void testSum () {
        int resault = calculator.sum(2,3);
        assertEquals(resault,5);
    }
    @Test
    public  void testMinus() {
        int resault = calculator.minus(10,5);
        assertEquals(resault,5);
    }

    /*@Test
    public void testDivision() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.division(20,0);
        });


    }*/
}

