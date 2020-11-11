package com.minos.threadcoreknowledge.sysnchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：
 *
 * @Author: minos
 * @Date: 2020/11/11 18:51
 */
public class SynchronizedToLock13 {

    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("I'm synchronized lock.");
    }

    public void method2() {
        // 这里显示的把加synchronized后的加锁的原理写出来了
        lock.lock();
        try {
            System.out.println("I'm Lock lock.");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock13 st = new SynchronizedToLock13();
        st.method1();
        st.method2();
    }
}
