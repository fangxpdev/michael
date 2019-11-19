package com.fangxp.concurrent;


/**
 * 1、所有的对象都有一个wait set，用来存放调用了该对象的wait方法之后进入block状态线程
 * 2、线程被notify之后，不一定立即执行
 * 3、线程从wait set中唤醒的顺序不一定是FIFO（先进先出）
 * 4、线程被唤醒后，必须重新获取锁
 */
public class WaitSet {

    public static final Object LOCK = new Object();

    private static void work() {
        synchronized (LOCK) {

            System.out.println("Begin....");

            System.out.println("Thread will coming...");

            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread will leave");

        }
    }

    public static void main(String[] args) throws InterruptedException {


        new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        }).start();

        Thread.sleep(1000L);

        synchronized (LOCK) {
            LOCK.notify();
        }

    }
}
