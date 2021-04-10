package com.flexi.elephant.loop;

import java.util.ServiceLoader;

/**
 * @author Lien6o
 * @date 2021/4/10 3:34 下午
 */
public class SpiLoopSupport {

    public static Loop getLoop() {
        ServiceLoader<Loop> loopServiceLoader = ServiceLoader.load(Loop.class);
        for (Loop loop : loopServiceLoader) {
            return loop;
        }
        return null;
    }
}
