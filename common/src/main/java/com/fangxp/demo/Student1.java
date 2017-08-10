package com.fangxp.demo;

/**
 * Created by tbj on 2017/6/26.
 */
public class Student1 {


    String name;

    String stuId;

    float score;

    public Student1(String name, String stuId, float score) {
        this.name = name;
        this.stuId = stuId;
        this.score = score;
    }

    public Student1() {
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", stuId='" + stuId + '\'' +
                ", score=" + score +
                '}';
    }

    public void test1() {
        Student1[] stu = new Student1[4];
        stu[0] = new Student1("张三", "5", 80f);
        stu[1] = new Student1("张三", "5", 80f);
        stu[2] = new Student1("张三", "5", 80f);
        stu[3] = new Student1("张三", "5", 80f);
    }

}
