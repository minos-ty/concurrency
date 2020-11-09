package com.minos.threadcoreknowledge.startthread;

/**
 * 描述：      对比start和run两种启动线程的方式
 * @Author: minos
 * @Date: 2020/11/9 15:34
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        /*
            这里的run其实就是一个普普通通的方法，和我们自己在定义的方法一样。并不会涉及底层和计算机的交互
         */
        runnable.run(); //main

        /**
         * start() 本质就是请求JVM来执行调用start()的程序
         * start() 执行后线程何时开启有JVM的线程调度机制决定
         * 只有当JVM有空闲时，才会开启线程
         */
        new Thread(runnable).start(); //Thread-0
    }
}
