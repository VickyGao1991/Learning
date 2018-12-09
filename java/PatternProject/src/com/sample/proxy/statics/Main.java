package com.sample.proxy.statics;

import java.util.Scanner;

/**
 * <<静态代理>>
 * 静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 * 可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 缺点:
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个数字: ");
        double firstNum = 0;
        try {
            firstNum = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("非法数字, 操作结束!");
            return;
        }

        System.out.println("请输入操作符(+/-): ");
        String operate = scanner.nextLine();
        if (!"+".equals(operate) && !"-".equals(operate)) {
            System.out.println("非法操作符, 操作结束!");
            return;
        }

        System.out.println("请输入第二个数字: ");
        double lastNum = 0;
        try {
            lastNum = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("非法数字, 操作结束!");
            return;
        }
        doExcute(operate, firstNum, lastNum);
    }

    /**
     */
    private static void doExcute(String operate, double firstNum, double lastNum) {
        IComputer proxy = null;
        if ("+".equals(operate)) {
            proxy = new AddComputerProxy();
        } else if ("-".equals(operate)) {
            proxy = new SubComputerProxy();
        }

        double result = proxy.excute(firstNum, lastNum);
        System.out.println("结果=" + result);
    }
}
