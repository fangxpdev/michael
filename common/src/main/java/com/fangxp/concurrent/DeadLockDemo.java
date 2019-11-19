package com.fangxp.concurrent;

public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";


    public static void main(String[] args) {

        deadLock();
    }

    private static void deadLock() {

        new Thread(()->{
            synchronized (A) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("Bbbb");
                }
            }
        },"he").start();

        new Thread(()->{
            synchronized (B) {
                synchronized (A) {
                    System.out.println("Aaaa");
                }
            }
        },"el").start();

    }

}
