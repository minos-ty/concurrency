package com.minos.jmm;

import java.util.concurrent.TimeUnit;

/**
 * 描述：      演示可见性带来的问题
 *
 * @Author: minos
 * @Date: 2020/11/14 22:52
 */
public class FiledVisibility {

    // 用volatile解决可见性问题
//    volatile int a = 1;
    int a = 1;
    // 这里其实只要给b修饰volatile就能保证 线程1 happens before 线程2
    volatile int b = 2;

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b = " + b + ", a = " + a);
    }

    public static void main(String[] args) {
        FiledVisibility test = new FiledVisibility();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.print();
            }
        }).start();
    }

}
