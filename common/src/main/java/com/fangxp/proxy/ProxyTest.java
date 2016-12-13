package com.fangxp.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/12/6.
 */
public class ProxyTest {
    public static void main(String[] args) throws Throwable {
        People people = (People) Proxy.newProxyInstance(People.class.getClassLoader(),
                new Class[]{People.class},new ProxyHandler(new Zhangsan()));
        people.eat();

        System.out.println(people.getClass().getName());

        createProxyClassFile();


    }

    /**
     * 还原代理类
     */
    public static void createProxyClassFile() throws IOException {
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{People.class});
        FileOutputStream out = new FileOutputStream("$Proxy0.class");
        out.write(data);
        out.close();
    }

}
