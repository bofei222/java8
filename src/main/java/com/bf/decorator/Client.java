package com.bf.decorator;

/**
 * @author bofei
 * @date 2018/9/7 13:25
 */
public class Client {
    public static void main(String[] args) {
        ICar car = new Car();
        SuperCar superCar = new SuperCar(new FlyCar(new WaterCar(new AICar(car))));
        superCar.move();
    }
}
