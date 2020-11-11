package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      类锁的第一种形式： static修饰的方法
 *
 * @Author: minos
 * @Date: 2020/11/11 12:16
 */
public class SynchronizedClassStatic4 implements Runnable {

    /**
     * 两个不同的Runnable对象
     */
    static SynchronizedClassStatic4 runnable1 = new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 runnable2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        method();

    }

    /**
     * 如果这里不加static, 由于两个线程是根据不同runnable方法创建的，是可以两个线程同步执行方法的
     * 加上 static后，这里的锁对象就是每一个类拥有的唯一的class对象，即锁唯一，这里不同的两个实例对象
     * 同属于一个类，共用同一把锁
     */
    public static synchronized void method() {

        System.out.println("类锁方式的第一种形式：static形式，" + Thread.currentThread().getName());
        try {
            // 是3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finished");
    }
}
