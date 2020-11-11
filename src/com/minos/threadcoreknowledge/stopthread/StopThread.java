package com.minos.threadcoreknowledge.stopthread;

/**
 * 描述：      错误的停止方法：应stop()来停止线程，会导致线程运行一半突然停止，
 *            没办法完成一个基本单位（一个连队）的操作，会造成脏数据
 *            （有的连队对领取装备，有的连队少领取）。
 *
 * @Author: minos
 * @Date: 2020/11/10 18:53
 */
public class StopThread implements Runnable {

    @Override
    public void run() {
        // 模拟指挥军队：一共有5个连队，每个连队10人，以连队为单位发放弹药,叫到号的士兵前去领取
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "完成领取");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 领着领着就开始打起来了
        thread.stop();
    }
}
