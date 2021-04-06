package com.flexi.elephant.loop;

/**
 * @author Lien6o
 * @description some desc
 * @email lienbo@meituan.com
 * @date 2021/4/6 3:49 下午
 */
public abstract class AbstractLoopEngine implements LifeCycle, Loop {
    protected LoopConfig config;


    public AbstractLoopEngine(LoopConfig config) {
        this.config = config;
    }

}
