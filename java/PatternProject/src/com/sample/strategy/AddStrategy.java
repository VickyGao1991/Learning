package com.sample.strategy;

public class AddStrategy extends Strategy {

    @Override
    public double excute(double firstNum, double lastNum) {
        return firstNum + lastNum;
    }

}
