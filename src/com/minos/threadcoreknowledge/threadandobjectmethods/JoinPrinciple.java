package com.minos.threadcoreknowledge.threadandobjectmethods;

/**
 * 描述：     通过讲解join原理，分析出join的代替写法
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        System.out.println("开始等待子线程运行完毕");
//        thread.join();  // join()的底层是wait,当thread类中run()方法全部执行完毕后，jvm底层有c++代码唤醒
        synchronized (thread) {  // 实现join()的等价代码
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
