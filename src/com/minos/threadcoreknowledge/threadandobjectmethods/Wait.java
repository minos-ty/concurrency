package com.minos.threadcoreknowledge.threadandobjectmethods;

import java.lang.reflect.Array;

/**
 * 描述：      展示wait()和notify()的基本用法， 这两个方法定义在Object类中
 * 1、研究代码执行顺序
 * 2、证明wait()释放锁
 *
 * @Author: minos
 * @Date: 2020/11/12 10:40
 */
public class Wait {

    public static Object object = new Object();

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "开始执行");
                try {
                    // 注意，这里使用锁对象来调用wait()方法,执行wait()时释放锁
                    object.wait();
                    System.out.println(Thread.currentThread().getName() + "获取到了锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName() + " 调用了notify()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}
