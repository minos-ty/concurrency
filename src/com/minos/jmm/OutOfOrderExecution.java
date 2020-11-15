package com.minos.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 描述：      演示重排序的现象，“直到达到某个条件才停止”，测试小概率事件
 *
 * @Author: minos
 * @Date: 2020/11/14 22:07
 */
public class OutOfOrderExecution {

//    private static int x = 0, y = 0;
//    private static int a = 0, b = 0;

    // 加上volatile禁止重排序后可以得到正确的结果 此时结果不会出现 0 0 的情况
    private volatile static int x = 0, y = 0;
    private volatile static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;


            // 让两个线程几乎同时执行run()中的代码，虽然使用了闸门来控制，但两个线程同时执行也是个概率事件
            CountDownLatch latch = new CountDownLatch(1);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 插上门栓
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });

            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });

            one.start();
            two.start();
            // 开门放狗
            latch.countDown();
            one.join();
            two.join();

            String result = "第" + i + "次 （" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}
