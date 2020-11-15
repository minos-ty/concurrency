package com.minos.singleton;

/**
 * 描述：      恶汉式（静态常量） （可用）
 * @Author: minos
 * @Date: 2020/11/15 14:06
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
