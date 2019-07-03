package com.bf.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author bofei
 * @date 2018/8/9 12:58
 */
public interface MyRemote extends Remote {
    String sayHeollo() throws RemoteException;
}
