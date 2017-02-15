package com.fangxp.hashmap;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by michael on 2017/1/22.
 * 无扩容版本
 */

public class CustHashMapTest {

    static CustMap hashMap = new CustNoExpanHashMap();


    @BeforeClass
    public static void before() {
        for (int i = 0; i < 12; i++) {

            System.out.println(hashMap.put("key" + i, "value" + i));
        }
    }

    @Test
    public void test1() throws Exception {
//        for (int i = 0; i < 12; i++) {
//
//            System.out.println(hashMap.put("key" + i, "value" + i));
//        }
        System.out.println("put======");
    }

    @Test
    public void test2() throws Exception {
        for (int i = 0; i < 12; i++) {
            System.out.println("key"+i+"对应的value:"+hashMap.get("key"+i));
        }
        System.out.println("size:"+hashMap.size());
    }

}