package com.hr.utils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-26
 */
public class ThreadUtils {
    private static int num;
    private static final Object obj = new Object();

    public static void main(String[] args) {
//        new Thread(() -> printNum(0)).start();
//        new Thread(() -> printNum(1)).start();
//        new Thread(() -> printNum(2)).start();
        new Thread(() -> printNum(0, "X")).start();
        new Thread(() -> printNum(1, "Y")).start();
        new Thread(() -> printNum(2, "Z")).start();
    }

    private static void printNum(int i) {
        synchronized (obj) {
            while (num < 100) {
                while (num % 3 != i) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                       // ignore
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                obj.notifyAll();
            }
        }
    }


    private static void printNum(int i, String x) {
        for (int j = 0; j < 100; j++) {
            synchronized (obj) {
                while (num % 3 != i) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(x);
                ++num;
                obj.notifyAll();
            }
        }
    }
}
