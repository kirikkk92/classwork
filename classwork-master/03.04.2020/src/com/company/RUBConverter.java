package com.company;

public class RUBConverter implements Converter {
    @Override
    public float convert(float value) {
        return value * 100 / 3.5f;
    }
}
