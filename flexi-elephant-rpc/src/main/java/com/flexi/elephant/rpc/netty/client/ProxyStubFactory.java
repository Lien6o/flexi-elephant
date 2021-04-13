package com.flexi.elephant.rpc.netty.client;

import com.flexi.elephant.rpc.netty.client.stubs.RpcRequest;
import com.flexi.elephant.rpc.netty.serialize.SerializeSupport;
import com.flexi.elephant.rpc.netty.transport.Transport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Lien6o
 * @date 2021/4/13 2:45 下午
 */
public class ProxyStubFactory implements StubFactory, InvocationHandler {

    private Transport transport;
    private Class<?> serviceClass;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T createStub(Transport transport, Class<T> serviceClass) {
        this.transport = transport;
        this.serviceClass = serviceClass;
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[]{serviceClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final byte[] serialize = SerializeSupport.serialize(args[0]);
        final byte[] buffer = StubSupport.invokeRemote(transport, new RpcRequest(serviceClass.getName(), method.getName(), serialize));
        return SerializeSupport.parse(buffer);
    }

}
