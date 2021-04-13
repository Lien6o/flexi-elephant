package com.flexi.elephant.rpc.netty.transport;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.TimeoutException;

/**
 *  
 * Date: 2019/9/25
 */
public interface TransportClient extends Closeable {
    Transport createTransport(SocketAddress address, long connectionTimeout) throws InterruptedException, TimeoutException;
    @Override
    void close();
}
