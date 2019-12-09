package com.wdq.pattern.builder;

/**
 * @author wudq
 * @date 2019/1/29 002910
 * @Description: TODO
 */
public class BuilderDemo {
    public static void main(String[] args) {
//        CarBuilder car = new CarBuilder.Builder().brand("宝马").price(100000.0).build();
//        System.out.println(car.toString());
        Car car = new Car("宝马", "black", 10.0, 100000.0);
     }
}
