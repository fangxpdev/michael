package com.fangxp;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michael on 2017/1/12.
 */
public class PatternTest {

    @Test
    public void test1() {
        Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");
        String msg = "[SYSTEM][124343423123][MICHAEL] - Student加入聊天室";
        String msg2 = "[LOGOUT][124343423123][MICHAEL]";
        String msg3 = "224324";
        Matcher m = pattern.matcher(msg);
        Matcher m2 = pattern.matcher(msg2);
        Matcher m3 = pattern.matcher(msg3);
        System.out.println(m);
        System.out.println("m.matches:"+m.matches());
        System.out.println("msg2"+m2.matches());
        System.out.println("msg3"+m3.matches());
        System.out.println(msg);
        Assert.assertTrue(m.matches());

    }

    @Test
    public void test2() {
        String str = " - Student加入聊天室";
        String pattern = "(\\s\\-\\s(.*))?";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

}
