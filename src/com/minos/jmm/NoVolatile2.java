package com.minos.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：      不适用于volatile的场景2
 * @Author: minos
 * @Date: 2020/11/15 13:03
 */
public class NoVolatile2 implements Runnable {

    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile2 r = new NoVolatile2();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(r.done);
        System.out.println(r.realA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            flipDone();
            realA.incrementAndGet();
        }
    }

    private void flipDone() {
        // 只要后面的值是依赖前面的值得，这种情况volatile就不适用了
        done = !done ;
    }
}