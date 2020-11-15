package com.minos.singleton;

/**
 * 描述：      懒汉式（线程安全） （不推荐用） 效率太低了
 * @Author: minos
 * @Date: 2020/11/15 14:06
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return  instance;
    }
}
