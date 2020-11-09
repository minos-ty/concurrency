package com.minos.threadcoreknowledge.stopthread;

/**
 * 描述：      run方法内没有sleep()/wait()时（普通情况下），停止线程
 * @Author: minos
 * @Date: 2020/11/9 18:51
 */
public class RightWayStopThreadWithoutSleep implements Runnable{

    @Override
    public void run() {
        int num = 0;
        /*
            !Thread.currentThread().isInterrupted()响应中断的语句，
            如果没有interrupted得到true循环继续，否则响应中断，结束循环
         */
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num%10000 == 0){
                System.out.println(num+"是一万的倍数");
            }
            num++;
        }
        System.out.println("运行结束.");

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
