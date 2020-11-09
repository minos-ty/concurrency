package com.minos.threadcoreknowledge.startthread;

/**
 * 描述：      不能调用两次start()方法
 * @Author: minos
 * @Date: 2020/11/9 18:16
 */
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        /**
         * 当线程对象调用start()启动线程后 threadStatus 不再是初始值 0
         * 此时如果再次调用start() 会执行以下代码抛出 IllegalThreadStateException
         *      if (threadStatus != 0)
         *          throw new IllegalThreadStateException();
         */
        thread.start();

    }
}
