package com.flexi.elephant.loop;

import java.util.ServiceLoader;

/**
 * @author Lien6o
 * @date 2021/4/10 3:34 下午
 */
public class SpiLoopSupport {

    public static EventLoop getLoop() {
        ServiceLoader<EventLoop> loopServiceLoader = ServiceLoader.load(EventLoop.class);
        for (EventLoop loop : loopServiceLoader) {
            return loop;
        }
        return null;
    }
}
