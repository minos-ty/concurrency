package com.minos.threadcoreknowledge.threadandobjectmethods;

import java.util.concurrent.TimeUnit;

/**
 * 描述：      演示join期间被中断的效果
 *
 * @Author: minos
 * @Date: 2020/11/12 22:13
 */
public class JoinInterrupted {

    public static void main(String[] args) {

        // 获得主线程的引用
        Thread mainThread = Thread.currentThread();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 子线程对主线程进行中断
                    mainThread.interrupt();
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("Thread1 finished.");
                } catch (InterruptedException e) {
                    System.out.println("Thread1 interrupted");
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+ " is interrupted.");
            e.printStackTrace();

            thread1.interrupt(); // 解决办法是当主线程被中断后，把中断传递给子线程
        }
        // main线程的WAITING状态被中断后，继续往下执行代码，而此时子线程并没有执行完毕
        System.out.println("子线程已经运行完毕");
    }
}
