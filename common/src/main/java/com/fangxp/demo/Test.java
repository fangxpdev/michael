package com.fangxp.demo;

/**
 * Created by tbj on 2017/7/26.
 */
public class Test {

    public static void main(String[] args) {
        Integer tableSuffixInt = 111111111 % 64 ;
        Integer tableSuffixInt2 = tableSuffixInt  / 4 * 4;
        System.out.println("1===>"+tableSuffixInt);
        System.out.println("2===>"+tableSuffixInt2);
    }

}
