package com.minos.singleton;

/**
 * 描述：      懒汉式（线程不安全） （不可用）
 * @Author: minos
 * @Date: 2020/11/15 14:06
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return  instance;
    }
}
