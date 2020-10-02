package com.company;

public class Main {

    public static void main(String[] args) {
        Lambda l = new Lambda();
        //1 способ без использования лямбда выражения
        l.setOnWorkListener(new Lambda.doSomething() {
            @Override
            public void doWork(String name) {
                System.out.println(name);
            }
        });
        //2 способ с использованием лямбда выражением
        l.setOnWorkListener((String s)->{
            System.out.println(s);

        });
    }

}

