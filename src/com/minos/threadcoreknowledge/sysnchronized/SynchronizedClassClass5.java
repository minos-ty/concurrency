package com.minos.threadcoreknowledge.sysnchronized;

/**
 * 描述：      类锁的第二种形式： 传入*.class对象到synchronized ()作为锁对象
 * @Author: minos
 * @Date: 2020/11/11 12:49
 */
public class SynchronizedClassClass5 implements Runnable{
    static SynchronizedClassClass5 runnable1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 runnable2 = new SynchronizedClassClass5();


    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("类锁的第二种形式synchronized (*.class) " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " 运行结束");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finished");
    }

}
