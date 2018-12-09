package com.sample.proxy.statics;

public class SubComputerProxy implements IComputer {

    private SubComputer subComputer;

    public SubComputerProxy() {
        this.subComputer = new SubComputer();
    }

    @Override
    public double excute(double firstNum, double lastNum) {
        // 执行目标方法前,做点啥?
        double result = subComputer.excute(firstNum, lastNum);
        // 执行目标方法前,做点啥?
        return result;
    }
}
