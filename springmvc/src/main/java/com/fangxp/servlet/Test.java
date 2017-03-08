package com.fangxp.servlet;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by michael on 2017/3/8.
 */
public class Test {



    public static void main(String[] args) {

//        System.out.println(Test.class.getResource("/com/fangxp"));

        String a = "micheal";
        a = StringUtils.join("/", a);
        System.out.println(a);
    }
}
