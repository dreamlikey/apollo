package com.wdq.pattern;


/**
 * Object clone的不足
 *  1、Object的clone方法是protected受保护的，子类重写clone方法时需要修改访问修饰符为public，
 *  不然在业务中使用clone时由于业务代码与javaBean没在同一个包package下会出现方法没有访问权限的编译错误
 *  2、重写clone方法，必须实现Cloneable接口，不然会抛出CloneNotSupportedException
 *
 *  Cloneable没有声明任何的实现方法，它仅仅是一个标识作用
 *   告诉jvm、告诉程序员要对这个类进行clone，
 *
 *
 * 深拷贝&浅拷贝
 * 拷贝构造器&拷贝工厂
 *
 * @author wudq
 * @date 2019/1/28
 * @Description: TODO
 */
public class CloneDemo extends Male{
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("李四",10);
        person.address = "成都";
        Work work = new Work("程序猿","xxx");
        person.setWork(work);
        Person person1 = (Person) person.clone();
        work = new Work("测试","yyy");
        System.out.println(work.toString());
        Male male = new Male();
//        male.test();
//        Female female = new Female();
//        female.test();


        System.out.println(person1.toString());
        System.out.println(person1.getWork() == person.getWork());
        System.out.println(person1.getWork().hashCode() == person.getWork().hashCode());
    }
}
