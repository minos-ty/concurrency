package com.minos.threadcoreknowledge.threadandobjectmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 描述：      每隔一秒输出当前时间，然后中断
 * <p>
 * sleep的两种写法：
 * Thread.sleep()
 * TimeUnit.SECONDS.sleep()   更优雅
 *
 * @Author: minos
 * @Date: 2020/11/12 21:30
 */
public class SleepInterrupted implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                /*
                 这里传入的参数单位就是秒， 这里就是睡三秒， 确实优雅了点 --
                 TimeUnit.HOURS.sleep(2); 优雅 哈哈哈
                 这个方法底层也是执行了Thread.sleep(),不过它自动帮我们进行了时间转换
                 而且这个方法在传入时间小于0的时候不会抛出异常中断程序，Thread.sleep()在
                 传入参数小于0的时候回抛出异常
                */
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // 如果程序能进到catch说明在睡眠的时候被中断
                e.printStackTrace();
                System.out.println("I'm interrupted (waked up and go to work!!!)...");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(6500);
        thread.interrupt();

    }
}
