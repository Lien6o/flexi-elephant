package com.flexi.elephant.rpc.netty.client;

import com.flexi.elephant.rpc.netty.transport.Transport;

/**
 *  
 * Date: 2019/9/27
 */
public interface ServiceStub {
    void setTransport(Transport transport);
}
