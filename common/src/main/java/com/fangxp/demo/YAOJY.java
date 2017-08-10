package com.fangxp.demo;

/**
 * Created by tbj on 2017/6/19.
 */
public class YAOJY {

    private String name;

    private String phone;

    /**
     * 默认无参数构造方法
     */
    public YAOJY() {
    }

    /**
     * 构造方法
     * @param name
     */
    public YAOJY(String name) {
        this.name = name;
    }

    /**
     * 构造方法
     * @param name
     * @param phone
     */
    public YAOJY(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "YAOJY{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //无参数构造方法，值需要设置
        YAOJY yaojy = new YAOJY();
        yaojy.setName("yao");
        yaojy.setPhone("2122321");

        //name 和 phone 构造方法初始化
        /**
         * 效果和上面的一样
         */
        YAOJY yaojy2 = new YAOJY("yao", "2122321");


        /**
         * 我这样写 调用的其实就是 定义的toString（） 方法
         */
        System.out.println(yaojy2);
    }




}
