package com.sample.simplefactory;

public class AddOperation extends Operation {

    @Override
    public double getResult() {
        return firstNum + lastNum;
    }

}
