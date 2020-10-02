package com.company;

public class USDConverter implements Converter {
    @Override
    public float convert (float value){
        return value / 2.6f;
    }
}
