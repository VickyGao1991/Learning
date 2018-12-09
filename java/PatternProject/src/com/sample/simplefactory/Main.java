package com.sample.simplefactory;

import java.util.Scanner;

/**
 * <<简单工厂模式>>
 * 就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 * 简单工厂模式的实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例
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

        /**
         * 工厂根据传入的参数, 创建相应的产品类对象并返回. 接下来,调用端操作的对象是产品类对象
         * */
        Operation operation = OperationFactory.getOperation(operate);
        operation.setFirstNum(firstNum);
        operation.setLastNum(lastNum);
        double result = operation.getResult();
        System.out.println("结果=" + result);
    }
}
