package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 描述：      证明wait()只释放当前的锁
 *
 * @Author: minos
 * @Date: 2020/11/12 13:25
 */
public class WaitNotifyReleaseOwnMonitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (resourceA) {
                    System.out.println("ThreadA got resourceA lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadA got resourceB lock.");
                        try {
                            System.out.println("ThreadA releases resourceA lock.");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resourceA) {
                    System.out.println("ThreadB got resourceA lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadB got resourceB lock.");
                    }
                }
            }
        });

        // 线程A先拿到锁resourceA 和 resourceB 然后让锁resourceB 等待，
        // resourceB的等待不影响resourceA，resourceA正常释放，线程B依然能够resourceA
        threadA.start();
        threadB.start();

    }
}
