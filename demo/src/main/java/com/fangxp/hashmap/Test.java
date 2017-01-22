package com.fangxp.hashmap;

/**
 * Created by michael on 2017/1/22.
 */
public class Test {

    public static void main(String[] args) {
        CustMap<String, String> hashMap = new CustHashMap();
        for (int i = 0; i < 10000; i++) {
            hashMap.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println("key"+i+"对应的value:"+hashMap.get("key"+i));
        }
        System.out.println("size:"+hashMap.size());

    }
}
