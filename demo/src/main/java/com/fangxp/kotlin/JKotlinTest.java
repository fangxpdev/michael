package com.fangxp.kotlin;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

import java.io.File;

/**
 * java 调用kotlin
 */
public class JKotlinTest {

    public static void main(String[] args) {
        File file = new File("michael.iml");
        System.out.println(FilesKt.readText(file, Charsets.UTF_8));

    }

}
