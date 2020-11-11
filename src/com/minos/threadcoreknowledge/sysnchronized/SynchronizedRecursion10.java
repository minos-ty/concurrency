package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      可重入粒度测试：递归调用本方法
 * @Author: minos
 * @Date: 2020/11/11 18:17
 */
public class SynchronizedRecursion10 {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion10 sr = new SynchronizedRecursion10();
        sr.method1();
    }

    /** synchronized 加锁的方法锁是可重入的 */
    public synchronized void method1() {
        System.out.println("method1 is running, a = " + a);
        if (a == 0) {
            a++;
            method1();
        }
    }
}
