package com.sample.proxy.cglib;

import java.util.Scanner;

/**
 * <<动态代理>>/<<JDK代理>/<<接口代理>>>
 * 动态代理代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型) 缺点:
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 */
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
        double result = 0;
        if ("+".equals(operate)) {
            AddComputer proxy = new AddComputer();
            AddComputer computer = (AddComputer) new ProxyFactory(proxy).getProxyInstance();
            result = computer.excute(firstNum, lastNum);
        } else if ("-".equals(operate)) {
            SubComputer proxy = new SubComputer();
            SubComputer computer = (SubComputer) new ProxyFactory(proxy).getProxyInstance();
            result = computer.excute(firstNum, lastNum);
        }
        System.out.println("结果=" + result);
    }
}
