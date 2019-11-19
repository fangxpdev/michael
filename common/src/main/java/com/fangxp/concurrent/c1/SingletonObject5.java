package com.fangxp.concurrent.c1;

public class SingletonObject5 {

    private SingletonObject5() {
    }

    /**
     * static 只初始化一次
     */
    private static class InstanceHolder {

        private final static SingletonObject5 instance = new SingletonObject5();

    }

    public static SingletonObject5 getInstance() {
        return InstanceHolder.instance;
    }
}
