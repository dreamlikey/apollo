package com.wdq.pattern.builder;

/**
 * @author wudq
 * @date 2019/1/29
 * @Description: TODO
 */
public class Car {
    private String brand;

    private String color;

    private Double length;

    private Double price;

    public Car(String brand, String color, Double length, Double price) {
        this.brand = brand;
        this.color = color;
        this.length = length;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
