package com.minos.threadcoreknowledge.sysnchronized;

/**
 * @Author: minos
 * @Date: 2020/11/11 13:30
 */
public class SynchronizedDifferentMethod7 implements Runnable{
    static SynchronizedDifferentMethod7 runnable = new SynchronizedDifferentMethod7();

    @Override
    public void run() {

        // 让两个方法同时被调用
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        }else {
            method2();
        }

    }

    public synchronized void method1() {
        System.out.println("加锁的方法1，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");
    }

    public synchronized void method2() {
        System.out.println("加锁的方法2，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");
    }

    /** 两个方法都加synchronized后共用一把锁this, 所以不能同时执行*/
    public  static void main(String[] args) {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finished");
    }
}
