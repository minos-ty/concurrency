package com.minos.threadcoreknowledge.sysnchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：      展示Lock方法
 * @Author: minos
 * @Date: 2020/11/11 19:32
 */
public class LockExample15 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        // lock.lock();
        lock.unlock();
        lock.tryLock();
        // lock.tryLock(1000, TimeUnit.SECONDS);

    }
}
