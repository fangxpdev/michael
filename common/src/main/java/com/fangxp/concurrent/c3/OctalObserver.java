package com.fangxp.concurrent.c3;

public class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("octal observer:" + Integer.toOctalString(subject.getState()));
    }
}
