package com.minos.threadcoreknowledge.threadandobjectmethods;

import java.util.concurrent.TimeUnit;

/**
 * 描述：      演示join， 注意语句的输出顺序， 会变化。
 *
 * @Author: minos
 * @Date: 2020/11/12 22:04
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished");
            }
        });


        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程执行完毕");

        // 加入到主线程后，主线程要等到子线程都执行完毕后才会执行后面的语句
//        thread1.join();
//        thread2.join();
        // 如果不join到主线程，主线程会先执行完毕而不会去等待子线程
        System.out.println("所有子线程执行完毕");

    }
}
