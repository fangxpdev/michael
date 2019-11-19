package com.fangxp.concurrent.c1;

public class SingletonObject4 {

    /**
     * volatile 保证先写完 再读  不能内存重排序
     */
    private static volatile SingletonObject4 instance;

    private SingletonObject4() {
        //初始化动作
        int i = 0;
        int j = 10;
    }

    /**
     * double check
     * instance 初始化未完成，其他线程就使用 可能导致空指针
     *
     * @return
     */
    public static SingletonObject3 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }

        return SingletonObject3.getInstance();

    }


}
