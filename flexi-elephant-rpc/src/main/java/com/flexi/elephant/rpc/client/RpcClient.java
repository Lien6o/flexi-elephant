package com.flexi.elephant.rpc.client;


import com.flexi.elephant.rpc.HelloService;
import com.flexi.elephant.rpc.api.NameService;
import com.flexi.elephant.rpc.api.RpcAccessPoint;
import com.flexi.elephant.rpc.api.spi.ServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;

/**
 *
 */
public class RpcClient {
    private static final Logger logger = LoggerFactory.getLogger(RpcClient.class);

    private RpcClient() {
        //no instance
    }

    public static <T> T getProxy(Class<T> service) throws Exception {
        File tmpDirFile = new File(System.getProperty("java.io.tmpdir"));
        File file = new File(tmpDirFile, "simple_rpc_name_service.data");
        try (RpcAccessPoint rpcAccessPoint = ServiceSupport.load(RpcAccessPoint.class)) {
            NameService nameService = rpcAccessPoint.getNameService(file.toURI());
            final String serviceName = service.getCanonicalName();
            URI uri = nameService.lookupService(serviceName);
            return rpcAccessPoint.getRemoteService(uri, service);
        }
    }


    public static void main(String[] args) throws Exception {
        final HelloService proxy = RpcClient.getProxy(HelloService.class);
        final String xxxxxxxx = proxy.hello("xxxxxxxx");
        System.out.println("xxxxxxxx = " + xxxxxxxx);

    }
}
