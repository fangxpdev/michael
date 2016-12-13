package com.fangxp.staticProxy;

/**
 * Created by Administrator on 2016/12/6.
 *
 * 静态代理
 * 1 持有被代理的引用
 * 2 代理类是一开始就加载到内存中的
 *
 */
public class Test {
    public static void main(String[] args) {
        People hisDaddy = new HisDaddy(new Zhangsan());

        hisDaddy.zhaoduixiang();

        People zhangsan = new Zhangsan();

        zhangsan.zhaoduixiang();

    }
}
