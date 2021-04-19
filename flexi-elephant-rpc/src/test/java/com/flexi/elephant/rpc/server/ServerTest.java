package com.flexi.elephant.rpc.server;


import java.io.Closeable;

/**
 * @author Lien6o
 * @description some desc
 * @date 2021/4/12 8:34 下午
 */
class ServerTest {

    public static void main(String[] args) throws Exception {
        startServer().close();
        System.out.println("startServer() = " + startServer());
    }

    public static synchronized Closeable startServer() throws Exception {

        return () -> {
            System.out.println("xxx");
        };

    }

}