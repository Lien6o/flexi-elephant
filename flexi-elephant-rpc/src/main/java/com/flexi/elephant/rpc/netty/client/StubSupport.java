package com.flexi.elephant.rpc.netty.client;

import com.flexi.elephant.rpc.netty.client.stubs.RpcRequest;
import com.flexi.elephant.rpc.netty.serialize.SerializeSupport;
import com.flexi.elephant.rpc.netty.transport.Transport;
import com.flexi.elephant.rpc.netty.transport.command.Code;
import com.flexi.elephant.rpc.netty.transport.command.Command;
import com.flexi.elephant.rpc.netty.transport.command.Header;
import com.flexi.elephant.rpc.netty.transport.command.ResponseHeader;

/**
 * @author Lien6o
 * @date 2021/4/13 2:57 下午
 */
public class StubSupport {
    /**
     * 子类使用
     */
    public static byte[] invokeRemote(Transport transport, RpcRequest request) {
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
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
