package com.sample.proxy.dynamic;

public class SubComputer implements IComputer{

    @Override
    public double excute(double firstNum, double lastNum) {
        return firstNum - lastNum;
    }

}
