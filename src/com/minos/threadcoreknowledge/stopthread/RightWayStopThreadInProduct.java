package com.minos.threadcoreknowledge.stopthread;

/**
 * 描述：      最佳实践1，实际生产中处理中断时，catch了InterruptedException之后
 *            应该优先选择: 在方法签名中抛出异常；如果这么做，那么run()
 *            中便会强制对该方法try/catch
 * @Author: minos
 * @Date: 2020/11/9 19:46
 */
public class RightWayStopThreadInProduct implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("Go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //  在这打印日志or停止程序，做自己的操作
                System.out.println("打印日志");
                e.printStackTrace();
            }
        }
    }

    /**
     * 应当把异常往上抛出给调用者，由顶层的调用者来决定怎么处理异常
     * @throws InterruptedException
     */
    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProduct());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
