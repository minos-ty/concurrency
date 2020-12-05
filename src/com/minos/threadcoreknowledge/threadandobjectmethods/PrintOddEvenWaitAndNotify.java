package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 面试题
 *
 * 描述：      两个线程交替打印0~100奇偶数，用wait()和notify实现。提高运行效率
 *
 * @Author: minos
 * @Date: 2020/11/12 19:28
 */
public class PrintOddEvenWaitAndNotify {

    private static int count;
    private static Object lock = new Object();

    //1.拿到锁就打印
    //2.打印完，唤醒其他线程，就休眠

    static class TuringRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() +":"+ count++);
                    // 打印完唤醒其他线程
                    lock.notify();

                    if (count <= 100) {
                        try {
                            // 如果任务还没结束，让出当前锁，进入休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            TuringRunner turingRunner = new TuringRunner();
            Thread thread1 = new Thread(turingRunner,"EvenThread");
            Thread thread2 = new Thread(turingRunner,"OddThread");
            thread1.start();
            // 确保线程一先执行
            Thread.sleep(100);
            thread2.start();
        }
    }


}
