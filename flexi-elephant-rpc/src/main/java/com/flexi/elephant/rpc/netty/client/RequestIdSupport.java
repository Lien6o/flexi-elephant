package com.flexi.elephant.rpc.netty.client;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  
 * Date: 2019/9/23
 */
public class RequestIdSupport {
    private final static AtomicInteger nextRequestId = new AtomicInteger(0);
    public static int next() {
        return nextRequestId.getAndIncrement();
    }
}
