package com.sample.simplefactory;

public class SubOperation extends Operation{

    @Override
    public double getResult() {
        return firstNum - lastNum;
    }

}
