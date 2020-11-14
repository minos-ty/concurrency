package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 描述：      线程sleep的时候不释放synchronize的monitor,等sleep时间到了以后
 * 且正常结束后才释放锁
 *
 * @Author: minos
 * @Date: 2020/11/12 20:37
 */
public class SleepDontReleaseMonitor implements Runnable {
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println(Thread.currentThread().getName() + " got monitor.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }

    public static void main(String[] args) {
        SleepDontReleaseMonitor runnable = new SleepDontReleaseMonitor();
        // sleep的时候线程一并不会释放锁
        new Thread(runnable).start();
        new Thread(runnable).start();

//        这种情况由于synchronized修饰的方法锁对象是this, 传入不同的对象相当于两个线程的锁是不一样的，所以并行执行
//        new Thread(new SleepDontReleaseMonitor()).start();
//        new Thread(new SleepDontReleaseMonitor()).start();
    }
}
