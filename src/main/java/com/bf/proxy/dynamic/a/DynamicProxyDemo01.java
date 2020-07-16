package com.bf.proxy.dynamic.a;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author bofei
 * @date 2018/8/9 17:56
 */
public class DynamicProxyDemo01 {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();    //1.创建委托对象
        ProxyHandler handler = new ProxyHandler(realSubject);   //2.创建调用处理器对象
        System.out.println("realSubject " + realSubject);

        // 为什么 可以强转， 因为 动态代理类 实现了 第二个参数类型的 的接口
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), handler);    //3.动态生成代理对象

        System.out.println("proxySubject " + proxySubject);
        System.out.println("proxySubject " + proxySubject.getClass().getName());


        proxySubject.request(); //4.通过代理对象调用方法
        proxySubject.request2(); //4.通过代理对象调用方法
    }
}

/**
 * 接口
 */
interface Subject{
    void request();
    void request2();
}

/**
 * 委托类
 */
class RealSubject implements Subject{
    public void request(){
        System.out.println("RealSubject.request");
    }
    public void request2(){
        System.out.println("RealSubject.request2");
    }
}
/**
 * 代理类的调用处理器
 */
class ProxyHandler implements InvocationHandler {
    private Subject subject;
    public ProxyHandler(Subject subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("====before====");//定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
        Object result = method.invoke(subject, args);
        System.out.println("====after====");
        return result;
    }
}
