package com.minos.threadcoreknowledge.sixstates;

/**
 * 描述：      展示线程的 NEW, RUNNABLE, TERMINATED 状态
 * 即使是线程正在运行，也是RUNNABLE
 *
 * @Author: minos
 * @Date: 2020/11/10 22:04
 */
public class NewRunnableTerminated implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new NewRunnableTerminated());
        // NEW
        System.out.println("未启动时的状态：" + thread.getState());

        thread.start();
        // RUNNABLE
        System.out.println("启动后的状态：" + thread.getState());

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // RUNNABLE
        System.out.println("运行中的状态" + thread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TERMINATED
        System.out.println("运行结束后的状态 ：" + thread.getState());
    }
}
