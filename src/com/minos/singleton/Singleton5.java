package com.minos.singleton;

/**
 * 描述：      懒汉式（线程不安全） （不可用）
 * @Author: minos
 * @Date: 2020/11/15 14:06
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return  instance;
    }
}
