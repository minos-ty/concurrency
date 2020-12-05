package com.minos.threadcoreknowledge.uncaughtexception;

/**
 * 描述：     使用自己写的UncaughtExceptionHandler
 */
public class UseOwnUncaughtExceptionHandler_04 implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler_03("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler_04(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler_04(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler_04(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler_04(), "MyThread-4").start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
