package com.minos.threadcoreknowledge.stopthread;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 描述：      run()中带有sleep()时（线程可能被阻塞），停止线程
 *
 * @Author: minos
 * @Date: 2020/11/9 19:03
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        // lambda方法实现runnable接口，和匿名内部类差不多
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 300) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是一百的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /*
            当线程正在休眠时接收到中断信号，会以抛出异常的形式来响应异常
            InterruptedException: sleep interrupted
         */
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt(); //InterruptedException: sleep interrupted
    }
}
