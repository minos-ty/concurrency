package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      方法抛出异常后，会释放锁。
 *            展示不抛出异常前和抛出异常后的对比：
 *                  一旦抛出异常，第二个线程会立刻进入同步方法，意味着锁已经释放。
 * @Author: minos
 * @Date: 2020/11/11 16:19
 */
public class SynchronizedException9 implements Runnable{

    static SynchronizedException9 runnable = new SynchronizedException9();

    @Override
    public void run() {

        // 让两个方法同时被调用
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }

    }

    public synchronized void method1() {
        System.out.println("抛出异常加锁的方法1，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }


    public synchronized void method2() {
        System.out.println("未抛出异常加锁的方法2，" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行完毕。");
    }


    /** Thread-0 调用的方法一抛出异常后， JVM会自动释放锁。
     * Thread-1 依然可以获得锁对象，执行方法二
     */
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
