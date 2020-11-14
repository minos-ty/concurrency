package com.minos.threadcoreknowledge.uncaughtexception;

import java.util.concurrent.TimeUnit;

/**
 * 描述：
 * 1.不加try catch抛出4个异常，都是带线程名的
 * 2.加了try catch,期望捕获到第一个线程的异常，线程345不应该运行，希望看到打印出Caught Exception
 * 3.执行时发现，根本没有Caught Exception, 线程234依然会运行并且抛出异常
 *
 * 说明线程的异常不能用传统方法捕获
 *
 * @Author: minos
 * @Date: 2020/11/13 10:24
 */
public class CantCatchDirectly implements Runnable{

    @Override
    public void run() {
        // throw new RuntimeException();
        // try catch直接方法run方法内可以无法直接捕获线程的问题，但这种方法不推荐
        try{
            throw new RuntimeException();
        }catch (RuntimeException e) {
            System.out.println("Caught Exception.");
        }

    }

    public static void main(String[] args) throws InterruptedException {
       try {
           new Thread(new CantCatchDirectly(),"MyThread-1").start();
           TimeUnit.MILLISECONDS.sleep(300);
           new Thread(new CantCatchDirectly(),"MyThread-2").start();
           new Thread(new CantCatchDirectly(),"MyThread-3").start();
           new Thread(new CantCatchDirectly(),"MyThread-4").start();
       }catch (RuntimeException e) {
           System.out.println("Caught Exception.");
       }

    }
}















