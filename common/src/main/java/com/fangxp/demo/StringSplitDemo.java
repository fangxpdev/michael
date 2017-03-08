package com.fangxp.demo;

/**
 * Created by michael on 2017/2/14.
 */
public class StringSplitDemo {

    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        for (String s : ary) {
            System.out.println(s);
        }
        //预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}
