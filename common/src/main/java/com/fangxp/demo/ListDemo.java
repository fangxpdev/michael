package com.fangxp.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tbj on 2017/5/19.
 */
public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<20;i++) {
            list.add(String.valueOf(i));
        }
        List<String> list1 = list.subList(0, 10);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
