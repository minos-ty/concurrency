package com.minos.threadcoreknowledge.sysnchronized;

import sun.lwawt.macosx.CSystemTray;

/**
 * 描述：      对象所示例1， 代码块形式
 *
 * @Author: minos
 * @Date: 2020/11/11 10:18
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 runnable = new SynchronizedObjectCodeBlock2();

    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {

        /** 锁对象可以设置成this, 也可以自定义对象 */
        synchronized (lock1) {
            System.out.println("lock1我是对象锁的方式修饰符形式，" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1运行结束");
        }

        /** 设置不同的锁可以实现线程并行执行 */
        synchronized (lock2) {
            System.out.println("lock2我是对象锁的方式修饰符形式，" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2运行结束");
        }
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
