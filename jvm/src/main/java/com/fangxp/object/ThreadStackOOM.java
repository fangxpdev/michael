package com.fangxp.object;

/**
 * 􏸀􏶋􏱆􏲶􏰧􏲿􏷗􏱙􏲺􏱦􏴛􏻆􏳸􏰢􏳜􏵞每个线程分配到的栈容量越大，可以建立的线程数量就越小
 * java.lang.OutOfMemoryError
 */
public class ThreadStackOOM {

    private void donstop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> donstop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        new ThreadStackOOM().stackLeakByThread();

    }

}
