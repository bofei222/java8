package com.bf.proxy.dynamic.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author bofei
 * @date 2018/8/10 11:21
 */
interface Star {
    void confer();
    void signContract();
    void bookTicket();
    void sing();
    void collectMoney();
}

class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney");
    }
}
class StarHandler implements InvocationHandler {
    private Star real;

    public StarHandler(Star real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        if (method.getName().equals("confer")) {
            System.out.println("前置处理");
            o = method.invoke(real, args);
            System.out.println("后置处理");
        } else {
            o = method.invoke(real, args);
        }
        return o;
    }
}

public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        StarHandler handler = new StarHandler(real);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        proxy.sing();
        proxy.confer();

    }
}