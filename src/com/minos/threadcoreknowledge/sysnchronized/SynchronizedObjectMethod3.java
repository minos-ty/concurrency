package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      对象所示例2， 方发锁形式
 *            面试题1：两个线程同时访问一个对象的同步方法，同一把锁，串行执行，实现线程安全
 * @Author: minos
 * @Date: 2020/11/11 11:02
 */
public class SynchronizedObjectMethod3 implements Runnable{

    static SynchronizedObjectMethod3 runnable = new SynchronizedObjectMethod3();

    @Override
    public void run() {
        method();
    }

    /** synchronized修饰普通方法，锁对象默认为this */
    public synchronized void method() {
        System.out.println("对象锁方式为方法修饰符形式，" + Thread.currentThread().getName());
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
