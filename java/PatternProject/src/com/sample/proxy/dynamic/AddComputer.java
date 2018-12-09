package com.sample.proxy.dynamic;

public class AddComputer implements IComputer{

    @Override
    public double excute(double firstNum, double lastNum) {
        return firstNum + lastNum;
    }

}
