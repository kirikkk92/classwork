package com.company;

public class MyExeptions extends RuntimeException {
    public MyExeptions () {
        super();
    }
    public String getMessage () {
        return "На ноль делить нельзя";
    }
}

