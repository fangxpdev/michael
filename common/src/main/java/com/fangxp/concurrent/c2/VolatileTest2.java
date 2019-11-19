package com.fangxp.concurrent.c2;

public class VolatileTest2 {
    private static  int INIT_VALUE = 0;

    private static int MAX_VALUE = 50;

    public static void main(String[] args) {

        new Thread(() -> {

            while (INIT_VALUE < MAX_VALUE) {
                System.out.println("T1-> " + ++INIT_VALUE);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "ADD-1").start();


        new Thread(() -> {

            while (INIT_VALUE < MAX_VALUE) {
                System.out.println("T2-> " + ++INIT_VALUE);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "ADD-2").start();
    }

}
