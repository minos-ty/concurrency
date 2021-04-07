package com.minos.threadcoreknowledge.createthreads;

/**
 * 描述：      用Thread方式实现线程
 * @Author: minos
 * @Date: 2020/11/8 20:40
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("继承Thread并重写run()实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
