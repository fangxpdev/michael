package com.fangxp.hashmap;

/**
 * Created by michael on 2017/1/22.
 *
 * 无扩容版本
 */
public class NoExpanTest {

    public static void main(String[] args) {
        CustMap hashMap = new CustNoExpanHashMap();

        for (int i = 0; i < 12; i++) {

            System.out.println(hashMap.put("key" + i, "value" + i));


        }
        System.out.println("put======");

        for (int i = 0; i < 12; i++) {
            System.out.println("key"+i+"对应的value:"+hashMap.get("key"+i));
        }
        System.out.println("size:"+hashMap.size());
    }
}
