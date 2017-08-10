package com.fangxp.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by tbj on 2017/8/3.
 */
public class ReflectDemo {

    public static void main(String[] args) {
        System.out.println("constructors==>"+Student1.class.getConstructors());

        System.out.println("methods===>"+Student1.class.getDeclaredMethods());

        for (Method method : Student1.class.getDeclaredMethods()) {
            System.out.println("method==>"+method);
        }

        for (Field field : Student1.class.getDeclaredFields()) {
            System.out.println("declared field==>"+field);
        }

        System.out.println("fileds == >"+Student1.class.getFields());

        for (Field field : Student1.class.getFields()) {
            System.out.println("field ===>"+field);
        }

        System.out.println(Student1.class.getClassLoader());
        System.out.println(Student1.class.getClassLoader().getParent());
        System.out.println(Student1.class.getClassLoader().getParent().getParent());


    }

}
