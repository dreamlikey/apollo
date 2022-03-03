package com.wdq.jvm;

/**
 * @author wudq
 * @date 2020/1/4 0004
 * @Description: TODO
 */
public class StackOverFlowDemo {
    public static void main(String[] args) {
        // 递归栈溢出
        overFlow();
        // 无限循环创建Student对象
        Student student = new Student();
    }

    public static void overFlow() {
        overFlow();
    }
}

class Person {
    int age;
    Student student = new Student();
}

class Student extends Person {
    String school;
}