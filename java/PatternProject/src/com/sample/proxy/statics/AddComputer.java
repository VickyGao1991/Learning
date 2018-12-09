package com.sample.proxy.statics;

public class AddComputer implements IComputer{

    @Override
    public double excute(double firstNum, double lastNum) {
        return firstNum + lastNum;
    }

}
