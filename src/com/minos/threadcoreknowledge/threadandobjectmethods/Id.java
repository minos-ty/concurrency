package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 描述：      线程id是从1开始的，Jvm运行起来后，我们自己创建的线程ID早已不是2
 * @Author: minos
 * @Date: 2020/11/13 09:41
 */
public class Id {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("mainThread ID: "+Thread.currentThread().getId());
        System.out.println("thread ID: " + thread.getId());
    }
}
