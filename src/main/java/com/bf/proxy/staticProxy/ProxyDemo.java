package com.bf.proxy.staticProxy;

/**
 * @author bofei
 * @date 2018/8/9 16:17
 */
public class ProxyDemo {
    public static void main(String args[]){
        RealSubject subject = new RealSubject();
        Subject p = new Proxy(subject); // 1. 代理对象可以伪装成 目标对象的 同一个 类型
        p.request();
    }
}

interface Subject{
    void request();
}

class RealSubject implements Subject {
    public void request(){
        System.out.println("request");
    }
}

// 1.为什么代理类要实现 相同的接口
class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject){
        this.subject = subject;
    }
    public void request(){
        System.out.println("PreProcess");
        subject.request();
        System.out.println("PostProcess");
    }
}
