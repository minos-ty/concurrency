package com.minos.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：      适用volatile的情况
 *
 * @Author: minos
 * @Date: 2020/11/15 13:11
 */
public class UseVolatile implements Runnable {

    volatile boolean done = false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        UseVolatile r = new UseVolatile();
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
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = true;
    }
}
