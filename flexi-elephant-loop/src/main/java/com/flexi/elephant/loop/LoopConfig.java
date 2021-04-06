package com.flexi.elephant.loop;

/**
 * @author Lien6o
 * @description some desc
 * @email lienbo@meituan.com
 * @date 2021/4/6 3:48 下午
 */
public class LoopConfig {


    private boolean defaultLoop;

    private Long threadStartTimeout;

    public Long getThreadStartTimeout() {
        return threadStartTimeout;
    }

    public boolean isDefaultLoop() {
        return defaultLoop;
    }
}
