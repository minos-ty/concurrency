package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 描述：      三个线程， 线程一和线程二先被阻塞，然后线程三再去唤醒它们。
 * 唤醒方法：notify() notifyAll()
 * 先执行start()的线程不代表其能先启动
 *
 * @Author: minos
 * @Date: 2020/11/12 12:50
 */
public class WaitNotifyAll implements Runnable {

    private static final Object resourceA = new Object();

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + " got a resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName() + " waits to start at next time.");
                // 调用wait()方法后会释放锁
                resourceA.wait();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " was started again and will be finished soon.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll runnable = new WaitNotifyAll();
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
                    // 只执行一次notify()只有第一个线程会被唤醒
//                    resourceA.notify();
//                    resourceA.notify();
                    System.out.println("ThreadC has notified");
                }
            }
        });

        threadA.start();
        threadB.start();

        // 确保前两个线程执行完
        Thread.sleep(200);

        // 启动后执行notifyAll()后哪个线程先拿到锁？threadA先拿到锁
        threadC.start();
    }
}



