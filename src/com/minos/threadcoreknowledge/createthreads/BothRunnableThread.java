package com.minos.threadcoreknowledge.createthreads;

/**
 * 描述：      同时使用两种方法
 *
 * @Author: minos
 * @Date: 2020/11/8 21:13
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        })
        // 重写Thread中的run()
        {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();

        /*
            输出: 我来自Thread
            原因: Thread中的run()方法已经被重写，
                  传入Runnable对象后不会执行：
                     if (target != null)
                         target.run();

         */


    }
}
