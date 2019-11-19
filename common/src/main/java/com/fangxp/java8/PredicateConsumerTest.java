package com.fangxp.java8;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerTest {

    public static Student updateStudentFee(Student student, Predicate<Student> p, Consumer<Student> consumer) {

        if (p.test(student)) {
            consumer.accept(student);
        }

        boolean test = p.and(student1 -> student1.grade > 3).test(student);
        System.out.println("test:" + test);

        return student;
    }



    public static void main(String[] args) {

        Student student = new Student("dou", "dou", 3d);


        Student student1 = updateStudentFee(student, new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.grade > 2;
            }
        }, new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                student.feeDiscount = 0.3;
            }
        });

        student1.printFee();

        Student stu = new Student("hua", "hua", 5d);


        Student student2 = updateStudentFee(stu, s -> s.grade >= 4, s2 -> s2.feeDiscount = 0.5);
        student2.printFee();




    }

}
