package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 面试题
 * 描述：      两个线程交替打印 0~100 奇偶数，用synchronized实现
 *
 * @Author: minos
 * @Date: 2020/11/12 18:59
 */
public class PrintOddEvenSynchronized {
    // 两个线程同时多一个静态变量操作，实际操作的是一个对象，不能用简单的顺序执行程序的思想来细究执行细节
    private static int count;
    private static Object lock = new Object();

    // 新建两个线程
    // 1个只处理偶数，另一个处理奇数(用位运算)
    // 用synchronized来通信
    public static void main(String[] args) {

        /**
         *
         *  这里有个问题，同一个线程可能会连续竞争到锁，虽然不会执行打印语句
         *  count也不会变，但是做了额为的判断，效率不高。
         *  一个更好的实现方法是使用 wait() and notify()
         *
         */

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    System.out.println(count);
                    // 因为synchronized是在count < 100里面的的， 两个线程同时对count++,另一个线程把count加到100
                    // 后这里就已经进入了while语句并且在synchronized处等待另一个线程释放锁，拿到锁以后便可输出100
                    // 当count==100以后两个线程都不再进入while循环
                    synchronized (lock) {
                        // 与1按位与，相当于把count的最低位取出来后和1与运算，
                        // 结果是1的话是奇数，是0则是偶数。效率比对2取模提高很多
                        if ((count & 1) == 0) {
                                System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        },"EvenThread").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    System.out.println("odd"+count);
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        },"OddThread").start();

    }

}
