package com.test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2018-12-25 21:14:23: this is method1. to wait...
 * 2018-12-25 21:14:28: this is method2. to sleep...
 * 2018-12-25 21:14:33: this is method2. wake...
 * 2018-12-25 21:14:36: this is method2. to notify others...
 * 2018-12-25 21:14:36: this is method1. wake...
 * */
public class Source {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Source instance = new Source();

    private Source() {
    }

    public static Source getInstance() {
        return instance;
    }

    public synchronized void method1() throws InterruptedException {
        System.out.println(df.format(new Date()) + ": this is method1. to wait...");
        Thread.sleep(5000);// 5s
        wait(); // will release the object lock
        System.out.println(df.format(new Date()) + ": this is method1. wake...");
    }

    public synchronized void method2() throws InterruptedException {
        System.out.println(df.format(new Date()) + ": this is method2. to sleep...");
        Thread.sleep(5000); // 5s
        System.out.println(df.format(new Date()) + ": this is method2. wake...");
        notifyAll(); // notify blocked thread which is waiting for this object's lock
        Thread.sleep(3000); // 3s
        // the lock will be actually released until the method return
        System.out.println(df.format(new Date()) + ": this is method2. to notify others...");
    }
}
