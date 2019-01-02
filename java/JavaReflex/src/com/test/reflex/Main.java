package com.test.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.test.reflex.model.People;

public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        // test6();
        // test7();
        test8();
    }

    private static void test8() throws ClassNotFoundException {
        System.out.println("*****START test7***************");
        Class<?> class1 = Class.forName("com.test.reflex.model.People");
        System.out.println("class loader name is "+class1.getClassLoader().getClass().getName());
        System.out.println("*****END test7***************");
    }

    /**
     * ͨ��������Ƶ����෽��
     * @throws ClassNotFoundException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InstantiationException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    private static void test7() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        System.out.println("*****START test7***************");
        Class<?> class1 = Class.forName("com.test.reflex.model.People");
        Method method = class1.getMethod("toString");
        method.invoke(class1.newInstance());
        System.out.println("*****END test7***************");
    }

    /**
     * ͨ������õ����һЩ���ԣ���Ա��Ϣ��������Ϣ�������ѻ�ø��ࡢ�̳еĽӿڵȵ�
     * 
     * @throws ClassNotFoundException
     */
    private static void test6() throws ClassNotFoundException {
        System.out.println("*****START test6***************");
        Class<?> class1 = Class.forName("com.test.reflex.model.People");
        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Field" + i + " name is " + fields[i].getName() + ", type is "
                    + fields[i].getGenericType().getTypeName());
        }
        Method[] methods = class1.getDeclaredMethods();
        for (int j = 0; j < methods.length; j++) {
            System.out.println("Method" + j + " name is " + methods[j].getName() + ", return type is "
                    + methods[j].getReturnType());
        }
        System.out.println("*****END test5***************");
    }

    /**
     * ͨ�����������Ա����
     * 
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws Exception
     */
    private static void test5() throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException, InstantiationException {
        System.out.println("*****START test5***************");
        Class<?> class1 = Class.forName("com.test.reflex.model.People");
        Object obj = class1.newInstance();
        Field field = class1.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj, "user1");
        System.out.println("people name is " + ((People) obj).getName());
        System.out.println("*****END test5***************");

    }

    /**
     * ͨ��java������Ƶõ�һ����Ĺ��캯������ʵ��������
     * 
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void test4() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        System.out.println("*****START test4***************");
        Class<?> class1 = Class.forName("com.test.reflex.model.People");
        Constructor<?>[] constructors = class1.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("constructor i =" + i);
            People people = (People) constructors[i].newInstance();
        }
        System.out.println("*****END test4***************");
    }

    /**
     * ͨ��java���������Class���������
     * 
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * 
     * @throws Exception
     */
    public static void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("*****START test3***************");
        Class<?> class1 = Class.forName("com.test.reflex.model.People");// ��̬�����࣬��ִ�о�̬�����
        People people = (People) class1.newInstance(); // ��仰��ִ�й��췽���� ��һ�к���һ���൱��People people = new People();
        System.out.println("*****END test3***************");
    }

    /**
     * ��֤�����඼��Class���ʵ������
     * 
     * @throws ClassNotFoundException
     */
    private static void test2() throws ClassNotFoundException {
        System.out.println("*****START test2***************");
        // ��̬������,��һ���Ѿ�ִ���˸����еľ�̬�����
        Class<?> class1 = Class.forName("com.test.reflex.model.People"); // load class dynamicly, static block will be
                                                                         // executed
        System.out.println("class package is " + class1.getClass().getPackage().getName() + ", class name is "
                + class1.getClass().getName());
        Class<?> class2 = People.class;
        System.out.println("class package is " + class2.getClass().getPackage().getName() + ", class name is "
                + class2.getClass().getName());
        System.out.println("*****END test1***************");
    }

    /**
     * ͨ��java������Ƶõ������Ϣ
     */
    private static void test1() {
        System.out.println("*****START test1***************");
        People people = new People();
        System.out.println("class package is " + people.getClass().getPackage().getName());
        System.out.println("class name is " + people.getClass().getName());
        System.out.println("*****END test1***************");
    }
}
