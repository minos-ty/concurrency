package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      可重入粒度测试：调用类内其他方法
 *
 * @Author: minos
 * @Date: 2020/11/11 18:25
 */
public class SynchronizedOtherMethod11 {

    public static void main(String[] args) {

        SynchronizedOtherMethod11 sy = new SynchronizedOtherMethod11();
        sy.method1();

    }

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " 我是method1");
        method2();
    }

    /**
     * 线程不用显示的去释放锁再获取锁 而是使用已经拿到的锁来用就行
     */
    private synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " 我是method2");
    }
}
