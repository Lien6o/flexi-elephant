package com.flexi.elephant.loop.threadpool;

import java.util.concurrent.Executor;

/**
 * @author Lien6o
 * @date 2021/4/10 4:27 下午
 */
public interface ExecutorSelector {

    Executor getExecutor();
}
