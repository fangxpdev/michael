package com.fangxp.demo;

import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * Created by michael on 2017/2/12.
 */
public class RefactDemo {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);

    }

    private static void method(int a, int b) {
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x) {
                if(x.startsWith("a")) super.println("a=100");
                if(x.startsWith("b")) super.println("b=200");
            }
        };
        System.setOut(ps);

    }

}
