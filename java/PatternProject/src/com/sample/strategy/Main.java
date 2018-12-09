package com.sample.strategy;

import java.util.Scanner;

/**
 * <<策略模式>>
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。
 * 策略模式使得算法可以在不影响到客户端的情况下发生变化。
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
     * 调用端先创建一个策略对象(AddStrategy/SubStrategy), 再创建一个Context类对象并传入已创建好的策略对象. 接下来,调用端操作的对象是Context
     * 
     * 环境(Context)角色: 持有一个Strategy的引用
     * 抽象策略(Strategy)角色: 这是一个抽象角色,通常由一个接口或抽象类实现.此角色给出所有的具体策略类所需的接口
     * 具体策略(AddStrategy/SubStrategy)角色: 包装了相关的算法或行为
     */
    private static void doExcute(String operate, double firstNum, double lastNum) {
        Strategy strategy = null;
        if ("+".equals(operate)) {
            strategy = new AddStrategy();
        } else if ("-".equals(operate)) {
            strategy = new SubStrategy();
        }

        Context Context = new Context(strategy);
        double result = Context.doExcute(firstNum, lastNum);
        System.out.println("结果=" + result);
    }
}
