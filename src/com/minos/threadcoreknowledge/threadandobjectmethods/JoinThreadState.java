package com.minos.threadcoreknowledge.threadandobjectmethods;

import java.util.concurrent.TimeUnit;

/**
 * 描述：      join期间线程的状态： WAITING
 *
 * @Author: minos
 * @Date: 2020/11/12 22:27
 */
public class JoinThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Main thread's state:" + mainThread.getState());
                    System.out.println("thread-0 finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread0.start();
        System.out.println("等在子线程运行完毕");
        thread0.join();
        System.out.println("子线程运行完毕");
    }
}
