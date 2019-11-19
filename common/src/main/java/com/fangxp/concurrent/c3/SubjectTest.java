package com.fangxp.concurrent.c3;

public class SubjectTest {

    public static void main(String[] args) {

        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("---------");
        subject.setState(10);
        System.out.println("--------");
        subject.setState(10);
        System.out.println("--------");
        subject.setState(15);
    }

}
