package com.bf.rmi.blueboz;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/4/20.
 * 定义一个远程接口，这个远程接口务必实现Remote接口
 */
public interface IHelloRMI extends Remote {
    /**
     * 一个最简单的Hello实例
     */
    public String sayHelloToClient()throws RemoteException;
}