package com.fangxp.concurrent.c3;

public class BinaryObserver extends Observer {


    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("binary observer:" + Integer.toBinaryString(subject.getState()));
    }
}
