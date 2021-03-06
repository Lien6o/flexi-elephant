package com.flexi.elephant.rpc.netty.client.stubs;


import com.flexi.elephant.rpc.netty.client.RequestIdSupport;
import com.flexi.elephant.rpc.netty.client.ServiceStub;
import com.flexi.elephant.rpc.netty.client.ServiceTypes;
import com.flexi.elephant.rpc.netty.serialize.SerializeSupport;
import com.flexi.elephant.rpc.netty.transport.Transport;
import com.flexi.elephant.rpc.netty.transport.command.Code;
import com.flexi.elephant.rpc.netty.transport.command.Command;
import com.flexi.elephant.rpc.netty.transport.command.Header;
import com.flexi.elephant.rpc.netty.transport.command.ResponseHeader;

import java.util.concurrent.ExecutionException;


public abstract class AbstractStub implements ServiceStub {

    protected Transport transport;

    /**
     * 子类使用
     */
    protected byte[] invokeRemote(RpcRequest request) {
        // 请求头
        Header header = new Header(ServiceTypes.TYPE_RPC_REQUEST, 1, RequestIdSupport.next());
        byte[] payload = SerializeSupport.serialize(request);
        Command requestCommand = new Command(header, payload);
        try {
            // send
            Command responseCommand = transport.send(requestCommand).get();
            ResponseHeader responseHeader = (ResponseHeader) responseCommand.getHeader();
            if (responseHeader.getCode() == Code.SUCCESS.getCode()) {
                return responseCommand.getPayload();
            } else {
                throw new Exception(responseHeader.getError());
            }

        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
