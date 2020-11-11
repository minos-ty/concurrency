package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      不使用synchronized时发生线程不安全
 *
 * @Author: minos
 * @Date: 2020/11/11 09:41
 */
public class DisappearRequest1 implements Runnable {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        DisappearRequest1 runnable = new DisappearRequest1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        // 这里两个线程都正常执行完了
        thread1.start();
        thread2.start();
        // join()方法就是指调用该方法的线程在执行完run()方法后，再执行join方法后面的代码，即将两个线程合并，用于实现同步控制。
        thread1.join();
        thread2.join();
        // 结果不符合预期200000是因为两个线程并没有同步操作
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
