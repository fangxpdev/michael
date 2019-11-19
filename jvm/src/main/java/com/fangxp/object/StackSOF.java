package com.fangxp.object;


/**
 * 栈溢出
 * -Xss160k
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) throws Throwable {
        StackSOF oom = new StackSOF();
        try {

            oom.stackLeak();

        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }

    }

}
