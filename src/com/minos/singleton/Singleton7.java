package com.minos.singleton;

/**
 * 描述：      静态内部类（推荐用 ）
 *
 * @Author: minos
 * @Date: 2020/11/15 14:06
 */
public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
