package com.minos.threadcoreknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 实现一个全局不能捕获子线程异常的处理器
 * 描述：     自己的MyUncaughtExceptionHandler
 */
public class MyUncaughtExceptionHandler_03 implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler_03(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，终止啦" + t.getName());
        System.out.println(name + "捕获了异常" + t.getName() + "异常");
    }
}
