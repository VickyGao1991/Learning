package com.sample.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double doExcute(double firstNum, double lastNum) {
        return strategy.excute(firstNum, lastNum);
    }
}
