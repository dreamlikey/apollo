package com.wdq.pattern.builder;

/**
 * @author wudq
 * @date 2019/1/29
 * @Description: TODO
 */
public class CarBuilder {
    private String brand;
    private String color;
    private Double length;
    private Double price;
    /**
     * 静态成员类
     * 构建器
     */
    public static class Builder {
        private String brand;
        private String color;
        private Double length;
        private Double price;
        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }
        public Builder color(String color) {
            this.color = color;
            return this;
        }
        public Builder length(Double length) {
            this.length = length;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }
        public CarBuilder build() {
            return new CarBuilder(this);
        }
    }
    public CarBuilder(Builder builder) {
        this.brand  = builder.brand;
        this.color  = builder.color;
        this.length = builder.length;
        this.price  = builder.price;
    }

    @Override
    public String toString() {
        return "CarBuilder{" +
            "brand='" + brand + '\'' +
            ", color='" + color + '\'' +
            ", length=" + length +
            ", price=" + price +
            '}';
    }
}
