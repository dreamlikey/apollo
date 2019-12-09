package com.wdq.pattern;

/**
 * @author wudq
 * @date 2019/1/28
 * @Description: TODO
 */
public class Person extends Object implements Cloneable{
    private String name;

    private Integer age;

    public String address;

    private Work work;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            ", work=" + work.toString() +
            '}';
    }

    protected void  test() {

    }
}
