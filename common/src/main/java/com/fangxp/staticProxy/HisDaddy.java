package com.fangxp.staticProxy;

/**
 * Created by Administrator on 2016/12/6.
 */
public class HisDaddy implements People {

    Zhangsan zs;

    public HisDaddy(Zhangsan zs) {
        this.zs = zs;
    }

    public void zhaoduixiang() {
        before();
        zs.zhaoduixiang();
        after();
    }

    private void before() {
        System.out.println("老子是张三的老子,先要过老子这关,要孝敬老子!!!");
    }

    private void after() {
        System.out.println("姑凉是个好gril!!!");
    }

}
