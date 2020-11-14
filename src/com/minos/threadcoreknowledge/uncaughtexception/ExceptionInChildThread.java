package com.minos.threadcoreknowledge.uncaughtexception;

/**
 * 描述：      单线程，抛出，处理，有异常堆栈
 *            多线程情况下，子线程发生异常，会出现什么情况？
 * @Author: minos
 * @Date: 2020/11/13 10:13
 */
public class ExceptionInChildThread implements Runnable{

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
