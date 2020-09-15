package com.company;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static Logger logger = LoggerFactory.getLogger(Calculator.class);

    public int sum(int a, int b) {
        logger.error("firstArgument = " + a  , "secondArgument = " + b);
        return a + b;

    }

    public int minus(int a, int b) {
        return a - b;
    }
}
