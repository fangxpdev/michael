package com.fangxp.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static int i = 0;


    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();
            try {
                while (i< 100) {


                    i++;
                    System.out.println("奇数：" + i);
                    condition.signal();
                    condition.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "jishu").start();


        new Thread(() -> {


            lock.lock();
            try {
                while (i<100) {

                    i++;
                    System.out.println("偶数：" + i);
                    condition.signal();
                    condition.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "偶数").start();


    }

}
