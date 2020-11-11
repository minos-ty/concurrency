package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：       同时访问同步方法和非同步方法  -> 并发执行两个方法，加了同步修饰符的方法不会影响到其他方法
 *
 * @Author: minos
 * @Date: 2020/11/11 13:18
 */
public class SynchronizedYseOrNo6 implements Runnable {

    static SynchronizedYseOrNo6 runnable = new SynchronizedYseOrNo6();

    @Override
    public void run() {

        // 确保两个方法被并发的调用
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        }else {
            method2();
        }

    }

    public synchronized void method1() {
        System.out.println("加锁的方法，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");
    }

    public void method2() {
        System.out.println("没加锁的方法，" + Thread.currentThread().getName());
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
