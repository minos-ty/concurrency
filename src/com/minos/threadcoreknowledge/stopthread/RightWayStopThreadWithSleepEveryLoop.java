package com.minos.threadcoreknowledge.stopthread;

/**
 * 描述：      如果在执行过程中，每次循环都会调用sleep()/wait()等方法
 * @Author: minos
 * @Date: 2020/11/9 19:16
 */
public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            try {

                //  如果没次循环中都有sleep()/wait()等方法 ，
                //  则不用!Thread.currentThread().isInterrupted()来判断是否响应中断
                //  因为线程休眠过程中收到中断请求，便会以抛出异常的方法来响应，改行代码显得多余
                while (num <= 1000) {
                    if (num%100 == 0) {
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();//InterruptedException: sleep interrupted

    }

}
