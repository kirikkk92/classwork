package com.company;

public interface Convertable<T extends Currency> {
    void convertTo(T currency);
}
