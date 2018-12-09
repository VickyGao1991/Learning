package com.sample.strategy;

public class SubStrategy extends Strategy{

    @Override
    public double excute(double firstNum, double lastNum) {
        return firstNum - lastNum;
    }
}
