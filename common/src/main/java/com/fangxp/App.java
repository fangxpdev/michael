package com.fangxp;

import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("test");
        System.out.println("test git flow for feature");

        ClassLoader cc = App.class.getClassLoader();
        while (cc != null) {
            System.out.println(cc);
            cc = cc.getParent();
        }


    }



}
