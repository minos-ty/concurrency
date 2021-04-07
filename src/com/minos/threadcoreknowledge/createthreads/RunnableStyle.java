package com.minos.threadcoreknowledge.createthreads;

/**
 * 描述:      用Runnable方式创建线程
 * @Author: minos
 * @Date: 2020/11/8 20:30
 */
public class RunnableStyle implements Runnable{

    @Override
    public void run() {
        System.out.println("实现Runnable接口并传入Thread类");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
