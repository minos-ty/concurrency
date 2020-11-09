package com.minos.threadcoreknowledge.stopthread;

/**
 * 描述：      如果while里面放try/catch，就算检查线程是否中断，已让会导致中断失效
 *
 * @Author: minos
 * @Date: 2020/11/9 19:30
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            // 虽然这里判断了中断状态，但是还是无法正常中断的原因是
            // 只要sleep()响应了中断，那么jvm虚拟机便会清除interrupt标记位，
            // 中断状态变为false，循环依旧满足条件可以正常运行，因为抛出异常并不会终止循环
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数。");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt(); //抛出异常后未能停止线程，线程依旧执行

    }
}
