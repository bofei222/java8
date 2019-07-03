package com.bf.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author bofei
 * @date 2018/8/9 13:02
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHeollo() throws RemoteException {
        return "Server says, 'Hey'";
    }
}
