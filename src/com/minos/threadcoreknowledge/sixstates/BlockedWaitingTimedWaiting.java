package com.minos.threadcoreknowledge.sixstates;

/**
 * 描述：      展示 BLOCKED， WAITING， TIMED_WAITING 状态
 * @Author: minos
 * @Date: 2020/11/10 22:21
 */
public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        // TIMED_WAITING， 因为正在执行 Thread.sleep(1000);
        System.out.println("thread1's state: " + thread1.getState());
        // BLOCKED, 英文thread2想拿到 syn() 方法的锁却拿不到
        System.out.println("thread2's state: " + thread2.getState());

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // WAITING, 因为执行了wait();
        System.out.println("thread1's state: " + thread1.getState());

    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
