package com.minos.threadcoreknowledge.sysnchronized;

/**
 * @Author: minos
 * @Date: 2020/11/11 15:32
 */
public class SynchronizedStaticAndNormal8 implements Runnable {

    static SynchronizedStaticAndNormal8 runnable = new SynchronizedStaticAndNormal8();

    @Override
    public void run() {

        // 让两个方法同时被调用
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }

    }

    /** 锁对象是class */
    public static synchronized void method1() {
        System.out.println("静态加锁的方法1，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");
    }

    /** 锁对象是this */
    public synchronized void method2() {
        System.out.println("非静态加锁的方法2，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finished");
    }
}
