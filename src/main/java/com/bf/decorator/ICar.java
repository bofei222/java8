package com.bf.decorator;

/**
 * @author bofei
 * @date 2018/9/7 12:52
 */
public interface ICar {
    void move();
}

// 真实对象
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

// 装饰器
class SuperCar implements ICar {
    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
//
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
//
class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("水里游");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}
//
class AICar extends SuperCar {

    public AICar(ICar car) {
        super(car);
    }

    public void auto() {
        System.out.println("自动跑");
    }

    @Override
    public void move() {
        super.move();
        auto();
    }
}

