package com.fangxp.concurrent;


public class OutPrint {


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() + ":" + i);
            }
        }, "thread0");

        thread1.start();


    }


}
