package com.fangxp.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest2 {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition jsc = lock.newCondition();

    private static Condition osc = lock.newCondition();

    private static int i = 0;


    public static void main(String[] args) {

        new Thread(() -> {


            while (i < 100) {
                try {
                    lock.lock();
                    i++;
                    System.out.println("奇数：" + i);
                    osc.signal();
                    jsc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }


        }, "jishu").start();


        new Thread(() -> {

            while (i < 100) {
                try {
                    lock.lock();
                    i++;
                    System.out.println("偶数：" + i);
                    jsc.signal();
                    osc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "偶数").start();


    }

}
