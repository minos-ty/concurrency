package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      可重入粒度测试：调用父类方法
 * @Author: minos
 * @Date: 2020/11/11 18:34
 */
public class SynchronizedSuperClass12 {

    public synchronized void doSomething() {
        System.out.println("我是父类");

    }
}

class TestClass extends SynchronizedSuperClass12{

    @Override
    public synchronized void doSomething() {
        System.out.println("我是子类");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass ts = new TestClass();
        ts.doSomething();
    }
}
