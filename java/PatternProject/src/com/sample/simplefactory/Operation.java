package com.sample.simplefactory;

public abstract class Operation {
    protected double firstNum;
    protected double lastNum;

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getLastNum() {
        return lastNum;
    }

    public void setLastNum(double lastNum) {
        this.lastNum = lastNum;
    }

    public abstract double getResult();
}
