package com.fangxp.concurrent.c2;



public class VolatileTest {

    /**
     * volatile 可见性  有序性
     */
    private static volatile int INIT_VALUE = 0;

    private static int MAX_VALUE = 50;

    public static void main(String[] args) {

        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue < MAX_VALUE) {
                if (localValue != INIT_VALUE) {
                    System.out.println("the value update to " + INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }

        },"READ").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_VALUE) {
                //直接用 ++INIT_VALUE  可能是read线程先打印哦
                System.out.println("value update to " + ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

}
