package com.minos.singleton;

/**
 * 描述：      恶汉式（静态代码块） （可用）
 * @Author: minos
 * @Date: 2020/11/15 14:06
 */
public class Singleton2 {

    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
