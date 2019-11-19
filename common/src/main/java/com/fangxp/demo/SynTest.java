package com.fangxp.demo;

public class SynTest {

    private static final Object object = new Object();

    private static int i = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (object) {
                while (i< 100) {

                    i++;
                    System.out.println("奇数：" + i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "jishu").start();


        new Thread(() -> {

            synchronized (object) {
                while (i< 100) {
                    i++;
                    System.out.println("偶数：" + i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }, "偶数").start();



    }

}
