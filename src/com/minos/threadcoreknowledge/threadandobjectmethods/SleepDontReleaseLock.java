package com.minos.threadcoreknowledge.threadandobjectmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：      sleep()不释放lock (注：lock本身是需要手动释放的)
 * @Author: minos
 * @Date: 2020/11/12 21:12
 */
public class SleepDontReleaseLock implements Runnable{

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " got lock");
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " is waked up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new SleepDontReleaseLock()).start();
        new Thread(new SleepDontReleaseLock()).start();

    }
}
