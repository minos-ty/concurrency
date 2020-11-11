package com.minos.threadcoreknowledge.stopthread;

/**
 * 描述：      最佳实践2，在catch子语句中调用Thread.currentThread().interrupt()来
 * 恢复设置中断状态，以便在后续的执行中，依然能够检查到刚才发生了中断
 * 回到刚才RightWayStopThreadInProduct补上中断，让它你跳出
 *
 * @Author: minos
 * @Date: 2020/11/9 19:46
 */
public class RightWayStopThreadInProduct2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted.");
                break;
            }
            System.out.println("Go");
            reInterrupt();
        }
    }

    /**
     * 不在方法签名上抛出中断， 在catch中再给一个中断信号，相当于重置中断标识
     *
     * @throws InterruptedException
     */
    private void reInterrupt() {
        try {
            // 以抛出异常的方式响应中断后，中断标识为 没中断
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 再次给一个中断信号, 中断标识为 中断了
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduct2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
