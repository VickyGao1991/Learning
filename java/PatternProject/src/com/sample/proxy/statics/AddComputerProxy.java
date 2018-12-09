package com.sample.proxy.statics;

public class AddComputerProxy implements IComputer {

    private AddComputer addComputer;

    public AddComputerProxy() {
        this.addComputer = new AddComputer();
    }

    @Override
    public double excute(double firstNum, double lastNum) {
        // 执行目标方法前,做点啥?
        double result = addComputer.excute(firstNum, lastNum);
        // 执行目标方法前,做点啥?
        return result;
    }

}
